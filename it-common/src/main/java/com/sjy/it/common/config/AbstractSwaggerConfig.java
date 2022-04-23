package com.sjy.it.common.config;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger配置类
 * springboot+swagger 接口测试框架
 * swagger有完整的文档
 */
public abstract class AbstractSwaggerConfig {


    /**
     *
     * @param title
     * @param desc
     * @param url
     * @param version
     * @param packageName controller的包
     * @return
     */
    public Docket createRestApi(String title, String desc, String url, String version, String packageName) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(myApiInfo(title, desc, url, version))
                .select()
                .apis(RequestHandlerSelectors.basePackage(packageName))
                .paths(PathSelectors.any())
                .build();

    }

    /**
     *
     * @param title swagger文档标题
     * @param desc 文档描述
     * @param url 参考地址
     * @param version 参考版本号
     * @return ApiInfo对象
     */
    protected ApiInfo myApiInfo(String title, String desc, String url, String version) {
        return new ApiInfoBuilder()
                .title(title)
                .description(desc)
                .termsOfServiceUrl(url)
                .version(version)
                .build();
    }
}
