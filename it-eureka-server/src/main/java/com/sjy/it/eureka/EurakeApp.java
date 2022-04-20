package com.sjy.it.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurakeApp {
    public static void main(String[] args) {
        SpringApplication.run(com.sjy.it.eureka.EurakeApp.class,args);
    }
}
