package com.japhy.bootstrap.web.infrastructure.config;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Japhy
 * @since 2021/1/10 09:35
 */
@Configuration
//@Profile("swagger")
public class SwaggerConfig {
    @Bean
    public Docket createAccountApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("user-api")
            .apiInfo(apiInfo())
            .produces(Sets.newHashSet("application/json"))
            .protocols(Sets.newHashSet("http"))
            .select()
            .paths(PathSelectors.regex(".*/user/.*"))
            .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
            .build();
    }

    @Bean
    public Docket createOrderApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("order-api").apiInfo(apiInfo())
            .produces(Sets.newHashSet("application/json"))
            .select()
            .paths(PathSelectors.regex(".*/order/.*"))
            .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Web Base API").description("this is the base api")
            .termsOfServiceUrl("www.web-base.com")
            .contact(new Contact("Japhy", "", "japhy.fan@gmail.ocm"))
            .license("Apache License Version 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
            .version("2.0")
            .build();
    }
}
