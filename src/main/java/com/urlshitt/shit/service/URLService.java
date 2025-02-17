package com.urlshitt.shit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.urlshitt.shit.CatchResponses;
import com.urlshitt.shit.cache.URLCaching;
import com.urlshitt.shit.data.DataAccessLayer;
import com.urlshitt.shit.data.PersistanceExecuter;
import com.urlshitt.shit.models.Response;
import com.urlshitt.shit.models.URLPojo;
import com.urlshitt.shit.utils.Utils;

import redis.clients.jedis.Jedis;

@Service
public class URLService {
  public static final Long USER_ID = 8973429876l; 
  @Autowired
  URLCaching catching;
  DataAccessLayer dataAccessLayer;
  Utils utils;
  PersistanceExecuter persistanceExecuter = new PersistanceExecuter(dataAccessLayer);
  ObjectMapper objectMapper;
  public URLService(Jedis jedis) {
    objectMapper = new ObjectMapper();
    catching = new URLCaching(jedis);
  }

  public Response createNewURL(URLPojo newUrlPojo) {
    try {
      Response res = new Response();
      boolean isUrlExist = persistanceExecuter.verifyUrlExistInDB(newUrlPojo.getUrlId());
      if (isUrlExist) {
        res.setName("message");
      res.setMessage("aleadyExist");
        return res;
      }
      utils.setUpdatedPojo(newUrlPojo);
      catching.post(newUrlPojo.toString(), objectMapper.writeValueAsString(newUrlPojo));
      persistanceExecuter.storeUrl(newUrlPojo);
      res.setName("success");
      res.setMessage(newUrlPojo.getUrl());
      return res;
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return null;
  }


  public URLPojo getUrl(Long urlId) {
    try {
      if (urlId == null) {
        return null;
      }
      String catchResponse = catching.get(urlId.toString());
      if (catchResponse.equals(CatchResponses.CACHE_NOT_FOUND)) {
        return null;
      }
      URLPojo urlPojo = objectMapper.readValue(catchResponse, URLPojo.class);
      return urlPojo;
    } catch (JsonProcessingException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }
}
