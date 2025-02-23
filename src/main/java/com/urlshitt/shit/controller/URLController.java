package com.urlshitt.shit.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:5173")
public class URLController {
  URLService urlService;
  @Autowired
  URLController(URLService urlService){
    this.urlService = urlService;
  }

  @GetMapping("/getallurl")
  public ResponseEntity<List<URLPojo>> getAllPojo() {
    return new ResponseEntity<>(urlService.getAllUserData(), HttpStatus.OK);
  }

  @GetMapping("/shorturl/{id}")
  public ResponseEntity<Response> getOriginalUrl(@PathVariable("id") String urlId, HttpServletResponse httpServletResponse) {
    try {
      Response res = new Response();
      String originalUrl = urlService.getOriginalUrl(urlId);
      if (originalUrl == null) {
        res.setName("message");
        res.setMessage("There is no Url like that");
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
      }
      httpServletResponse.sendRedirect(originalUrl);
      return new ResponseEntity<>(res, HttpStatus.OK);
    } catch (Exception e) {

    }
    return null;
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
