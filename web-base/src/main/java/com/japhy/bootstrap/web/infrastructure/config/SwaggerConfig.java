package com.japhy.bootstrap.web.infrastructure.config;

import static org.springdoc.core.utils.Constants.ALL_PATTERN;


import com.japhy.bootstrap.web.application.wrapper.ApiError;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Japhy
 * @since 2021/1/10 09:35
 */
@Configuration
//@Profile("swagger")
public class SwaggerConfig {

    @Bean
    @ConditionalOnMissingBean(WebSecureConfig.class)
    public OpenAPI webBaseOpenAPI(@Value("${springdoc.version}") String appVersion) {
        return createOpenApi(appVersion);
    }

    private static OpenAPI createOpenApi(String appVersion) {
        return new OpenAPI()
                .info(new Info().title("Web Base API")
                        .description("this is the base api")
                        .version(appVersion)
                        .contact(new Contact().name("japhy"))
                        .license(new License().name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("google")
                        .url("https://www.google.com"));
        // Schema resultEntitySchema = ModelConverters.getInstance()
        //         .resolveAsResolvedSchema(new AnnotatedType(ResultEntity.class)).schema;
        //
        // ApiResponse apiResponse = new ApiResponse().content(
        //                 new Content().addMediaType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
        //                         new MediaType()
        //                                 .schema(resultEntitySchema.description("Schema 1"))
        //                                 .addExamples("defult",
        //                                         new Example().value("{123}").description("this is description").summary("SUMMARY"))))
        //         .description("My response description");
    }

    @Bean
    @ConditionalOnBean(WebSecureConfig.class)
    public OpenAPI securedOpenAPI(@Value("${springdoc.version}") String appVersion) {
        return createOpenApi(appVersion)
                .addSecurityItem(new SecurityRequirement().addList("bearer-key"))
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer")
                                        .bearerFormat("JWT")));
    }


    // @Bean
    // @Profile("!prod")
    // public GroupedOpenApi actuatorApi(OpenApiCustomizer actuatorOpenApiCustomizer,
    //         OperationCustomizer actuatorCustomizer,
    //         WebEndpointProperties endpointProperties,
    //         @Value("${springdoc.version}") String appVersion) {
    //     return GroupedOpenApi.builder()
    //             .group("Actuator")
    //             .pathsToMatch(endpointProperties.getBasePath() + ALL_PATTERN)
    //             .addOpenApiCustomizer(actuatorOpenApiCustomizer)
    //             .addOpenApiCustomizer(openApi -> openApi.info(
    //                     new Info().title("Actuator API").version(appVersion)))
    //             .addOperationCustomizer(actuatorCustomizer)
    //             .pathsToExclude("/health/*")
    //             .build();
    // }

    //     private ApiInfo apiInfo() {
//         return new ApiInfoBuilder().title("Web Base API").description("this is the base api")
//             .termsOfServiceUrl("www.web-base.com")
//             .contact(new Contact("Japhy", "", "japhy.fan@gmail.ocm"))
//             .license("Apache License Version 2.0")
//             .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
//             .version("2.0")
//             .build();
//     }

    // @Bean
    // public GroupedOpenApi adminApi() {
    //     return GroupedOpenApi.builder()
    //             .group("springshop-admin")
    //             .pathsToMatch("**/users/**")
    //             .build();
    // }

}
