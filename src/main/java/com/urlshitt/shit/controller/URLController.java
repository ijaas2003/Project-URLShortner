package com.urlshitt.shit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.urlshitt.shit.models.Response;
import com.urlshitt.shit.models.URLPojo;
import com.urlshitt.shit.service.URLService;

import jakarta.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/api")

public class URLController {
  URLService urlService;
  @Autowired
  URLController(URLService urlService){
    this.urlService = urlService;
  }

  // @GetMapping("/urls")
  // public ResponseEntity<List<URLPojo>> findAll() {
  //   return new ResponseEntity<>(urlService.getUrls(), HttpStatus.OK);
  // }
  @GetMapping("/shorturl/{id}")
  public void getOriginalUrl(@PathVariable("id") String urlId, HttpServletResponse httpServletResponse) {
    try {
      String originalUrl = urlService.getOriginalUrl(urlId);
      if (originalUrl == null) {
        httpServletResponse.sendRedirect("/error");
      }
      httpServletResponse.sendRedirect(originalUrl);
    } catch (Exception e) {

    }
    
  }
  @PostMapping("/url")
  public ResponseEntity<Response> newURL(@RequestBody URLPojo newUrl) {
  Response response = urlService.createNewURL(newUrl);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }
  @GetMapping("/geturl/{id}")
  public ResponseEntity<URLPojo> getURL(@PathVariable("id") Long urlId) {
    URLPojo urlPojo = urlService.getUrl(urlId);
    return new ResponseEntity<>(urlPojo, HttpStatus.OK);
  }
}
