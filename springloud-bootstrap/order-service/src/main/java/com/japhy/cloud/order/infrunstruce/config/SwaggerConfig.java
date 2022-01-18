package com.japhy.cloud.order.infrunstruce.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Japhy
 * @since 2022/1/17 18:16
 */
@Configuration
public class SwaggerConfig {

//    @Bean
//    public GroupedOpenApi usersGroup(@Value("${springdoc.version}") String appVersion) {
//        return GroupedOpenApi.builder().group("users")
//                .addOperationCustomizer((operation, handlerMethod) -> {
//                    operation.addSecurityItem(new SecurityRequirement().addList("basicScheme"));
//                    return operation;
//                })
//                .addOpenApiCustomiser(openApi -> openApi.info(new Info().title("Users API").version(appVersion)))
//                .packagesToScan("org.springdoc.demo.app2")
//                .build();
//    }
//    @Bean
//    public OpenAPI getOpenApiDocumentation() {
//        return new OpenAPI().info(
//                new Info().title(apiTitle).description(apiDescription).version(apiVersion).contact(
//                                new Contact().name(apiContactName).url(apiContactUrl)
//                                        .email(apiContactEmail)).termsOfService(apiTermsOfService)
//                        .license(new License().name(apiLicense).url(apiLicenseUrl))).externalDocs(
//                new ExternalDocumentation().description(apiExternalDocDesc).url(apiExternalDocUrl));
//    }

}
