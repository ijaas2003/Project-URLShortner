package com.urlshitt.shit.data;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.urlshitt.shit.models.URLPojo;
import com.urlshitt.shit.models.URlMapping;

@Component
public class PersistanceExecuter {
  
  private final DataAccessLayer dataAccessLayer;
  private final Mapping mapping;

  @Autowired
  public PersistanceExecuter(DataAccessLayer dataAccessLayer, Mapping mapping) {
    this.dataAccessLayer = dataAccessLayer;
    this.mapping = mapping;
  }
  
  public boolean verifyUrlExistInDB(String url) {
    return dataAccessLayer.existsByUrl(url);
  }

  public boolean storeUrl(URLPojo urlPojo) {
    return dataAccessLayer.save(urlPojo) != null;
  }
  public void storeMapping(URlMapping urlMapping) {
    mapping.save(urlMapping);
  }
  public Optional<URlMapping> getURlMapping(String url) {
    return mapping.findById(url);
  }
  public Optional<URLPojo> getUrl(Long urlId) {
    return dataAccessLayer.findById(urlId);
  }
}
