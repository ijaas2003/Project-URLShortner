package com.urlshitt.shit.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class URLPojo {

  @Id
  private Long urlId;
  private String userName;
  private String email;
  private String tinyURL;
  private String url;
  private String userId;

  public Long getUrlId() {
    return this.urlId;
  }
  public String getTinyURL() {
    return this.tinyURL;
  }
  public String getUserName() {
    return this.userName;
  }
  public String getEmail() {
    return this.email;
  }
  public String getUrl() {
    return this.url;
  }
  public String getUserId() {
    return this.userId;
  }
  

    public void setUrlId(Long urlId){
      this.urlId = urlId;
    }
    public void settinyURL(String tinyURL){
      this.tinyURL = tinyURL;
    }
    public void setUserName(String userName) {
      this.userName = userName;
    }
    public void setEmail(String email) {
      this.email = email;
    }
    public void setUrl(String url) {
      this.url = url;
    }
    public void setUserId(String userId) {
      this.url = userId;
    }
  @Override
  public String toString() {
    return "URLPojo{" +
    "urlId=" + urlId +
    ",userName='" + userName + '\'' +
    ", email='" + email + '\'' +
    ", tinyURL='" + tinyURL + '\'' +
    ", url='" + url + '\'' +
    ", userId'" + userId + '\'' +
    '}';
  }
}
