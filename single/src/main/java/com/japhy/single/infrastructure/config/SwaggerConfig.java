package com.japhy.single.infrastructure.config;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Japhy
 * @date 2019/12/29 02:26
 */
@Configuration
@EnableSwagger2
@Profile({"dev", "test"})
public class SwaggerConfig {

    @Bean
    public Docket createAccountApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("account-api")
                .apiInfo(apiInfo())
                .produces(Sets.newHashSet("application/json"))
                .protocols(Sets.newHashSet("http"))
                .select()
                .paths(PathSelectors.regex(".*/account/.*"))
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
        return new ApiInfoBuilder().title("Wer Account API").description("this is the account api")
                .termsOfServiceUrl("www.wer.com")
                .contact(new Contact("Japhy", "", "japhy.fan@gmail.ocm"))
                .license("Apache License Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .version("2.0")
                .build();
    }
}