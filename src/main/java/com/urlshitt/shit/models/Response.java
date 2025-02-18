package com.urlshitt.shit.models;
public class Response {
  private String name = "messagr";
  private String message = "success";
  public void setName(String name) {
    this.name = name;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  public String getName() {
    return this.name;
  }
  public String getMessage() {
    return this.message;
  }
}
