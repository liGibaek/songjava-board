package com.example.songjava.board.config;

import org.springframework.beans.factory.annotation.Value;
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
    @Value("${apiInfo.title}")
    private String title;
    @Value("${apiInfo.description}")
    private String description;
    @Value("${apiInfo.version}")
    private String version;
    @Value("${apiInfo.termsOfServiceUrl}")
    private String termsOfServiceUrl;
    @Value("${apiInfo.name}")
    private String name;
    @Value("${apiInfo.url}")
    private String url;
    @Value("${apiInfo.email}")
    private String email;
    @Value("${apiInfo.license}")
    private String license;
    @Value("${apiInfo.licenseUrl}")
    private String licenseUrl;

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                .termsOfServiceUrl(termsOfServiceUrl)
                .contact(new Contact(name, url, email))
                .license(license)
                .licenseUrl(licenseUrl)
                .build();
    }

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.songjava.board.controller"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(apiInfo());
    }
}
