package com.urlshitt.shit.service;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.urlshitt.shit.CatchResponses;
import com.urlshitt.shit.cache.URLCaching;
import com.urlshitt.shit.data.PersistanceExecuter;
import com.urlshitt.shit.models.Response;
import com.urlshitt.shit.models.URLPojo;
import com.urlshitt.shit.utils.Utils;

@Service
public class URLService {

  private final URLCaching catching;
  private final PersistanceExecuter persistanceExecuter;
  private final ObjectMapper objectMapper;
  private final Utils utils;

  @Autowired
  public URLService(URLCaching catching, PersistanceExecuter persistanceExecuter, ObjectMapper objectMapper, Utils utils) {
    this.catching = catching;
    this.persistanceExecuter = persistanceExecuter;
    this.objectMapper = objectMapper;
    this.utils = utils;
  }

  public Response createNewURL(URLPojo newUrlPojo) {
    try {
      Response res = new Response();
      utils.setUpdatedPojo(newUrlPojo);
      System.out.println("Generatedid " + newUrlPojo.getUrlId());
      boolean isUrlExist = persistanceExecuter.verifyUrlExistInDB(newUrlPojo.getUrl());

      if (isUrlExist) {
        res.setName("message");
        res.setMessage("alreadyExist");
        return res;
      }

      catching.post(newUrlPojo.getUrlId().toString(), objectMapper.writeValueAsString(newUrlPojo));
      persistanceExecuter.storeUrl(newUrlPojo);

      res.setName("success");
      res.setMessage(newUrlPojo.getUrl());
      return res;
    }catch (JSONException e) {
    }catch (Exception e) {
    }
    return null;
  }

  public URLPojo getUrl(Long urlId) {
    if (urlId == null) return null;

    String cacheResponse = catching.get(urlId.toString());
    if (cacheResponse.equals(CatchResponses.CACHE_NOT_FOUND)) return null;

    try {
      return objectMapper.readValue(cacheResponse, URLPojo.class);
    } catch (Exception e) {
      return null;
    }
  }
}
