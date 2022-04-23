package com.sjy.it.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
        //(exclude = {DruidDataSourceAutoConfigure.class, DataSourceAutoConfiguration.class})
//@EntityScan(basePackages = "com.sjy.it.domain.entity")
public class UserApp {
    public static void main(String[] args) {

        SpringApplication.run(UserApp.class,args);

    }
}
