package com.sjy.it.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
        //(exclude = {DruidDataSourceAutoConfigure.class, DataSourceAutoConfiguration.class})
public class UserApp {
    public static void main(String[] args) {

        SpringApplication.run(UserApp.class,args);

    }
}
