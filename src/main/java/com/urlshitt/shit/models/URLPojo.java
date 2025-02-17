package com.urlshitt.shit.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "urlpojo")
public class URLPojo {

  @Id
  private Long url_id;
  private String userName;
  private String email;
  private String tinyURL;
  private String url;
  private String user_id;

  public Long getUrlId() {
    return this.url_id;
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
    return this.user_id;
  }
  

    public void setUrlId(Long urlId){
      this.url_id = urlId;
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
      this.user_id = userId;
    }
  @Override
  public String toString() {
    return "URLPojo{" +
    "urlId=" + url_id +
    ",userName='" + userName + '\'' +
    ", email='" + email + '\'' +
    ", tinyURL='" + tinyURL + '\'' +
    ", url='" + url + '\'' +
    ", userId'" + user_id + '\'' +
    '}';
  }
}
