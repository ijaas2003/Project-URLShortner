package com.urlshitt.shit.config;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Jedis;

@Configuration
public class RedisConfig {
  @Bean
  public JedisPool jedisPool(){
    JedisPoolConfig poolConfig = new JedisPoolConfig();
    poolConfig.setMaxTotal(10);
    poolConfig.setMaxIdle(10);
    poolConfig.setMaxWait(Duration.ofSeconds(5));
    return new JedisPool(poolConfig, "localhost", 6379);
  }
  
  @Bean
  public Jedis jedis(JedisPool jedisPool) {
    return jedisPool.getResource();
  }
}
