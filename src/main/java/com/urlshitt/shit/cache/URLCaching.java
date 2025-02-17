package com.urlshitt.shit.cache;

import org.springframework.stereotype.Component;

import com.urlshitt.shit.CatchResponses;
import com.urlshitt.shit.logging.Logging;

import redis.clients.jedis.Jedis;

@Component
public class URLCaching {

  Jedis jedis;
  Logging logger = new Logging();
  public URLCaching(Jedis jedis) {
    this.jedis = jedis;
  }
  
  // ? We use read-Through Catching algorithm
  public String get(String key){
    if (jedis.exists(key)) {
      return jedis.get(key);
    }
    return CatchResponses.CACHE_NOT_FOUND;
  }

  // ? We use write-Through Catching algorithm
  public String post(String key, String value) {
    try {
      jedis.set(key, value);
      
      return CatchResponses.CACHE_POST_SUCCESS;
    } catch (Exception e) {
      logger.Log(LoggingLevels.SEVERE, e.getMessage(), getClass());
    }
    return CatchResponses.CACHE_POST_ERROR;
  }
}
