package com.daisyowl.hbapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class HBApi {
  public static void main(String[] args) {
    ConfigurableApplicationContext appContext = SpringApplication.run(HBApi.class, args);
  }
}
