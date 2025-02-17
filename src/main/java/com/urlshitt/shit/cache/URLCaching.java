package com.urlshitt.shit.cache;

import org.springframework.stereotype.Component;

import com.urlshitt.shit.CatchResponses;

import redis.clients.jedis.Jedis;

@Component
public class URLCaching {

  private final Jedis jedis;

  public URLCaching(Jedis jedis) {
    this.jedis = jedis;
  }

  public String get(String key){
    return jedis.exists(key) ? jedis.get(key) : CatchResponses.CACHE_NOT_FOUND;
  }

  public String post(String key, String value) {
    try {
      jedis.set(key, value);
      return CatchResponses.CACHE_POST_SUCCESS;
    } catch (Exception e) {
      return CatchResponses.CACHE_POST_ERROR;
    }
  }
}
