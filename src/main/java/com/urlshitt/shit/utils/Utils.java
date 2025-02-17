package com.urlshitt.shit.utils;

import com.urlshitt.shit.models.URLPojo;

public class Utils {
  public static final Long USER_ID = 8973429876l; 
  RandomGeneration randomGeneration = new RandomGeneration();;
  public void setUpdatedPojo(URLPojo urlPojo) {
    Long id = randomGeneration.Generate();
    urlPojo.setUrlId(id);
    urlPojo.setUserId(USER_ID.toString());
  }
}
