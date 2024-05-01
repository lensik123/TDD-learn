package org.example.configuration;

public class DatabaseConfiguration {
  public void configure(){
    if ("IN_MEMORY".equals(System.getProperty("DB"))){

    } else if ("REAL_DB".equals(System.getProperty("DB"))) {


    }
  }

}
