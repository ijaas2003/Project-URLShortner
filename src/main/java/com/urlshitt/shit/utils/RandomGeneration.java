package com.urlshitt.shit.utils;

import java.security.SecureRandom;
import java.util.Random;

public class RandomGeneration {
  private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();
  public Long Generate() {
    Random random = new Random();
    Long min = 1000000000L;
    Long max = 9999999999L;
    return min + (long) (random.nextDouble() * (max - min + 1));
  }
  public String generateTinyURL() {
    StringBuilder stringBuilder = new StringBuilder("https://tinyURL/");
    for (int i = 0; i < 10; i++) {
      stringBuilder.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
    }
    return stringBuilder.toString();
  }
}
