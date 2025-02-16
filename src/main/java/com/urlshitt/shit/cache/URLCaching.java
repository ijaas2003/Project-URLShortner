package com.urlshitt.shit.cache;

import com.urlshitt.shit.CatchResponses;
import com.urlshitt.shit.logging.Logging;

import redis.clients.jedis.Jedis;

public class URLCaching {


  Jedis jedis;
  Logging logger = new Logging();
  public URLCaching(Jedis jedis) {
    this.jedis = jedis;
  }

  public String get(String key){
    if (jedis.exists(key)) {
      return jedis.get(key);
    }
    return CatchResponses.CACHE_NOT_FOUND;
  }

  public String post(String key, String value) {
    try {
      jedis.sadd(key, value);
      return CatchResponses.CACHE_POST_SUCCESS;
    } catch (Exception e) {
      logger.Log(LoggingLevels.SEVERE, e.getMessage(), getClass());
    }
    return CatchResponses.CACHE_POST_ERROR;
  }
}
