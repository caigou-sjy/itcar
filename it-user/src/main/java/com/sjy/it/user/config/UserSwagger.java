package com.sjy.it.user.config;

import com.sjy.it.common.config.AbstractSwaggerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class UserSwagger extends AbstractSwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return super.createRestApi(
                "智慧优游租车系统-子系统-用户模块",
                "用户模块",
                "https://www.baidu.com",
                "v1.0",
                "com.sjy.it.user.controller"
        );
    }
}
