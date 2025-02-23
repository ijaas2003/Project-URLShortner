package com.urlshitt.shit.service;

import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.urlshitt.shit.CatchResponses;
import com.urlshitt.shit.cache.URLCaching;
import com.urlshitt.shit.data.PersistanceExecuter;
import com.urlshitt.shit.models.Response;
import com.urlshitt.shit.models.URLPojo;
import com.urlshitt.shit.models.URlMapping;
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
      URlMapping mapping = new URlMapping();
      utils.setUpdatedPojo(newUrlPojo, mapping);
      boolean isUrlExist = persistanceExecuter.verifyUrlExistInDB(newUrlPojo.getUrl());
      if (isUrlExist) {
        res.setName("message");
        res.setMessage("alreadyExist");
        return res;
      }
      persistanceExecuter.storeMapping(mapping);
      System.out.println("Generatedid " + newUrlPojo.getUrlId());


      catching.post(newUrlPojo.getUrlId().toString(), objectMapper.writeValueAsString(newUrlPojo));
      persistanceExecuter.storeUrl(newUrlPojo);

      res.setName("success");
      res.setMessage(newUrlPojo.getTinyURL());
      return res;
    }catch (JSONException e) {
    }catch (Exception e) {
    }
    return null;
  }

  public String getOriginalUrl (String url) {
    try {
      String urlId;
      Optional<URlMapping> URLmappingPojo = persistanceExecuter.getURlMapping(url);
      if (URLmappingPojo.isEmpty()) {
        return null; 
      }
      else if (URLmappingPojo.isPresent()) {
        urlId  = URLmappingPojo.get().geturlId();
        String isUrlInCache = catching.getUrl(urlId);
        if (isUrlInCache != null) {
          return objectMapper.readValue(isUrlInCache, URLPojo.class).getUrl();
        }
        Optional<URLPojo> urlPojo = persistanceExecuter.getUrl(Long.parseLong(urlId));
        if (urlPojo.isPresent()) {
          return urlPojo.get().getUrl();
        }
      }
    } catch (Exception E) {
      System.out.println(E.getMessage());
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
  public List<URLPojo> getAllUserData() {
    return persistanceExecuter.getAll();
  }
}
