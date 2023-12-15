package com.example.tatarestapitest.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.tatarestapitest")) // Replace with your package name
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Tata REST API DOCUMENTATION")
                .description("A Spring Boot REST API managing tasks with basic CRUD operations. Utilizes H2 in-memory database, featuring endpoints for listing tasks, retrieving by ID, creating, updating, and deleting tasks. Input validation ensures required fields. Documented using Swagger for simplicity.")
                .version("1.0.0")
                .build();
    }
}