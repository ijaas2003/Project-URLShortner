package com.urlshitt.shit.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class URlMapping {
  @Id
  private String genUrlId;
  private String urlId;

  public String getGenUrlId () {
    return this.genUrlId;
  }
  public String geturlId () {
    return this.urlId;
  }
  public void setGenUrlId(String genUrlId) {
    this.genUrlId = genUrlId;
  }
  public void seturlId(String urlId) {
    this.urlId = urlId;
  }
}
