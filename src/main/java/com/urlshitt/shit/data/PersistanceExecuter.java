package com.urlshitt.shit.data;

import org.springframework.beans.factory.annotation.Autowired;

import com.urlshitt.shit.cache.URLCaching;
import com.urlshitt.shit.models.URLPojo;
import com.urlshitt.shit.CatchResponses;
public class PersistanceExecuter {
  
  DataAccessLayer dataAccessLayer;
  URLCaching urlCaching;
  
  @Autowired
  public PersistanceExecuter(DataAccessLayer dataAccessLayer) {
    this.dataAccessLayer = dataAccessLayer;
  }
  
  public boolean verifyUrlExistInDB(Long urlId) {
    String isExist = urlCaching.get(urlId.toString());
    if (isExist.equals(CatchResponses.CACHE_NOT_FOUND)) {
      return dataAccessLayer.existsById(urlId);
    }
    return false;
  }

  public boolean storeUrl(URLPojo urlPojo) {
    return dataAccessLayer.save(urlPojo) != null;
  }
}
