package com.sjy.it.car.config;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger配置类
 * @author dyit
 */
public abstract class AbstractSwaggerConfig {


    public Docket createRestApi(String title,String desc,String url,String version,String packageName){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(myApiInfo(title,desc,url,version))
                .select()
                .apis(RequestHandlerSelectors.basePackage(packageName))
                .paths(PathSelectors.any())
                .build();

    }


    protected ApiInfo myApiInfo(String title,String desc,String url,String version){
        return new ApiInfoBuilder()
                .title(title)
                .description(desc)
                .termsOfServiceUrl(url)
                .version(version)
                .build();
    }
}
