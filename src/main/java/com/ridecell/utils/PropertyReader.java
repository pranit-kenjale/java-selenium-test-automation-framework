package com.ridecell.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

  public static String getProperty(String propertyName) {
    Properties properties = null;
    try {
      FileReader reader = new FileReader(".\\src\\main\\resources\\config\\custom.properties");
      properties = new Properties();
      properties.load(reader);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return properties.getProperty(propertyName);
  }

}
