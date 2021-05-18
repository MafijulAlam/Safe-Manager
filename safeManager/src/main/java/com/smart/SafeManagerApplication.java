package com.smart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class , ErrorMvcAutoConfiguration.class})

public class SafeManagerApplication {

    public static void main(String[] args) {

        SpringApplication.run(SafeManagerApplication.class, args);

    }

}
