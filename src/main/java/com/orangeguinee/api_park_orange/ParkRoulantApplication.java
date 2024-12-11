package com.orangeguinee.api_park_orange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ParkRoulantApplication {

    public static void main(String[] args) {


        SpringApplication.run(ParkRoulantApplication.class, args);


    }



}
