package com.samsungsds.eshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    private ApiInfo swaggerInfo() {
        return new ApiInfoBuilder().title("E-SHOP API Document")
                .description("E-SHOP API에 대한 설명 페이지")
                .license("")
                .licenseUrl("http://unlicense.org")
                .termsOfServiceUrl("")
                .version("v1")
                .contact(new Contact("","", ""))
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
            .useDefaultResponseMessages(false)    
            .apiInfo(swaggerInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.samsungsds.eshop")) // 해당 경로 내에 있는 API들을 대상으로 한다.
            .paths(PathSelectors.ant("/api/**"))
            .build();
    }
}