package com.urlshitt.shit.utils;

import java.security.SecureRandom;
import java.util.Random;

import com.urlshitt.shit.models.URlMapping;

public class RandomGeneration {
  private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();
  public Long Generate() {
    Random random = new Random();
    Long min = 1000000000L;
    Long max = 9999999999L;
    return min + (long) (random.nextDouble() * (max - min + 1));
  }
  public String generateTinyURL(URlMapping mapping) {
    StringBuilder stringBuilder = new StringBuilder("http://localhost:8080/api/shorturl/");
    StringBuilder stringBuilder2 = new StringBuilder("");
    for (int i = 0; i < 10; i++) {
      stringBuilder2.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
    }
    mapping.setGenUrlId(stringBuilder2.toString());
    stringBuilder.append(stringBuilder2);
    return stringBuilder.toString();
  }
}
