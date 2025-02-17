package com.urlshitt.shit.utils;

import java.util.Random;

public class RandomGeneration {
  public Long Generate() {
    Random random = new Random();
    Long min = 1000000000L;
    Long max = 9999999999L;
    return min + (long) (random.nextDouble() * (max - min + 1));
  }
}
