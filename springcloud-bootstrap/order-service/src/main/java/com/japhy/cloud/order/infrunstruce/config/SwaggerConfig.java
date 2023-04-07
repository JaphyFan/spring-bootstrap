package com.japhy.cloud.order.infrunstruce.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Japhy
 * @since 2022/1/17 18:16
 */
@Configuration
public class SwaggerConfig {

    // @Bean
    // public GroupedOpenApi usersGroup(@Value("${springdoc.version:1.0.0}") String appVersion) {
    //     return GroupedOpenApi.builder().group("users")
    //             .addOperationCustomizer((operation, handlerMethod) -> {
    //                 operation.addSecurityItem(new SecurityRequirement().addList("basicScheme"));
    //                 return operation;
    //             })
    //             .addOpenApiCustomiser(openApi -> openApi.info(new Info().title("Order API").version(appVersion)))
    //             .packagesToScan("org.japhy.cloud.order")
    //             .build();
    // }


}
