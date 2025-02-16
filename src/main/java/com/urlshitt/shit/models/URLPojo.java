package com.urlshitt.shit.models;

public class URLPojo {
  private Long urlId;
  private String userName;
  private String email;
  private String tinyURL;
  private String url;

  public Long getUrlId() {
    return this.urlId;
  }
  public String getTinyURL() {
    return this.tinyURL;
  }
  public String getUserName() {
    return this.userName;
  }
  public String getUserEmail() {
    return this.email;
  }
  public String getUrl() {
    return this.url;
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
}
