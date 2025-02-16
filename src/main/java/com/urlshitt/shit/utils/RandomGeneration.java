package com.urlshitt.shit.utils;

import java.util.Random;

public class RandomGeneration {
  public static String Generate() {
    Random random = new Random();
    Long min = 1000000000L;
    Long max = 9999999999L;
    Long generated = min + (long) (random.nextDouble() * (max - min + 1));
    return generated.toString();
  }
}
