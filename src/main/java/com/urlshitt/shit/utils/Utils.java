package com.urlshitt.shit.utils;

import org.springframework.stereotype.Component;

import com.urlshitt.shit.models.URLPojo;

@Component
public class Utils {
  public static final Long USER_ID = 8973429876l; 
  RandomGeneration randomGeneration = new RandomGeneration();;
  public void setUpdatedPojo(URLPojo urlPojo) {
    Long id = randomGeneration.Generate();
    String tinyUrl = randomGeneration.generateTinyURL();
    urlPojo.setUrlId(id);
    urlPojo.settinyURL(tinyUrl);
    urlPojo.setUserId(USER_ID.toString());
  }
}
