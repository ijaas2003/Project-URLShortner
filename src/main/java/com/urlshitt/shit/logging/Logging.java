package com.urlshitt.shit.logging;

import java.io.FileWriter;
import java.io.IOException;

public class Logging {
  FileWriter fileWriter;
  public Logging() {
    
  }
  public void Log(String Level, String message, Class<?> currentClass) {
    try {
      fileWriter = new FileWriter("Logging.txt", false);
      fileWriter.write("LEVEL = " + Level + "MESSAGE = "+ message + "CLASS = " + currentClass);
    } catch (IOException e) {
      System.out.println("e" + e.getMessage());
    }
  }
}
