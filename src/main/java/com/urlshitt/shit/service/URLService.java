package com.urlshitt.shit.service;

import java.net.CacheResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urlshitt.shit.cache.URLCaching;
import com.urlshitt.shit.models.Response;
import com.urlshitt.shit.models.URLPojo;

import redis.clients.jedis.Jedis;

@Service
public class URLService {
  @Autowired
  URLCaching catching;
  public URLService(Jedis jedis) {
    catching = new URLCaching(jedis);
  }

  public Response createNewURL(URLPojo newUrlPojo) {
    Response res = new Response();
    res.setName("success");
    res.setMessage(newUrlPojo.getUrl());
    return res;
  }

  public URLPojo getUrl(Long urlId) {
    String catchResponse = catching.get(urlId.toString());
    if (catchResponse.equals(Ca)) {

    }
  }
}
