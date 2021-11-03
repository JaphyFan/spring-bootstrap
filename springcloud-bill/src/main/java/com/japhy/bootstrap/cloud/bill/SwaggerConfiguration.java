package com.japhy.bootstrap.cloud.bill;


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
 * @since 2021/3/16 13:55
 */
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket createOrderApi() {
        return new Docket(DocumentationType.OAS_30)
            .groupName("bill-api").apiInfo(apiInfo())
            .produces(Sets.newHashSet("application/json"))
//            .securityContexts(singletonList(securityContext()))
//            .securitySchemes(singletonList(apiKey()))
            .select()
            .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("bill API").description("this is the bill api")
            .termsOfServiceUrl("term.japhy.com")
            .contact(new Contact("Japhy", "", "japhy.fan@gmail.ocm"))
            .license("Apache License Version 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
            .version("2.0")
            .build();
    }
}
