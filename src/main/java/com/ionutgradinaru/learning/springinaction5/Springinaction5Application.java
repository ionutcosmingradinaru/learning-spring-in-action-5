package com.ionutgradinaru.learning.springinaction5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class Springinaction5Application {

  public static void main(String[] args) {
    SpringApplication.run(Springinaction5Application.class, args);
  }
}
