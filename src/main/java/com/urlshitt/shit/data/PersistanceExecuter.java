package com.urlshitt.shit.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.urlshitt.shit.CatchResponses;
import com.urlshitt.shit.cache.URLCaching;
import com.urlshitt.shit.models.URLPojo;

@Component
public class PersistanceExecuter {
  
  private final DataAccessLayer dataAccessLayer;
  private final URLCaching urlCaching;

  @Autowired
  public PersistanceExecuter(DataAccessLayer dataAccessLayer, URLCaching urlCaching) {
    this.dataAccessLayer = dataAccessLayer;
    this.urlCaching = urlCaching;
  }
  
  public boolean verifyUrlExistInDB(String url) {
    return dataAccessLayer.existsByUrl(url);
  }

  public boolean storeUrl(URLPojo urlPojo) {
    return dataAccessLayer.save(urlPojo) != null;
  }
}
