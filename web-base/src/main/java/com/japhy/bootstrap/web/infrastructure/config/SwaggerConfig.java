package com.japhy.bootstrap.web.infrastructure.config;

import static org.springdoc.core.utils.Constants.ALL_PATTERN;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
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

//     @Bean
//     public Docket createOrderApi() {
//         return new Docket(DocumentationType.OAS_30)
//             .groupName("order-api").apiInfo(apiInfo())
//             .produces(Sets.newHashSet("application/json"))
//             .securityContexts(singletonList(securityContext()))
//             .securitySchemes(singletonList(apiKey()))
//             .select()
//             .paths(PathSelectors.ant("/**/orders/**"))
//             .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).build();
//     }
//
//
//     private ApiInfo apiInfo() {
//         return new ApiInfoBuilder().title("Web Base API").description("this is the base api")
//             .termsOfServiceUrl("www.web-base.com")
//             .contact(new Contact("Japhy", "", "japhy.fan@gmail.ocm"))
//             .license("Apache License Version 2.0")
//             .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
//             .version("2.0")
//             .build();
//     }
//
//     //FIXME: security 配置 japhy 2021/1/21
// //    @Autowired
// //    private TypeResolver typeResolver;
// //
//     private ApiKey apiKey() {
//         return new ApiKey("Authorization", "Authorization", "header");
//     }
//
//     private SecurityContext securityContext() {
//         return SecurityContext.builder()
//             .securityReferences(defaultAuth())
//             .operationSelector(operationContext -> operationContext.requestMappingPattern().startsWith("/api/"))
//             .build();
//     }
//
//     List<SecurityReference> defaultAuth() {
//         AuthorizationScope authorizationScope
//             = new AuthorizationScope("global", "accessEverything");
//         AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//         authorizationScopes[0] = authorizationScope;
//         return singletonList(
//             new SecurityReference("Authorization", authorizationScopes));
//     }
//
//    @Bean
//    SecurityConfiguration security() {
//        return SecurityConfigurationBuilder.builder()
//            .clientId("test-app-client-id")
//            .clientSecret("test-app-client-secret")
//            .realm("test-app-realm")
//            .appName("test-app")
//            .scopeSeparator(",")
//            .additionalQueryStringParams(null)
//            .useBasicAuthenticationWithAccessCodeGrant(false)
//            .enableCsrfSupport(false)
//            .build();
//    }
//
//    @Bean
//    UiConfiguration uiConfig() {
//        return UiConfigurationBuilder.builder()
//            .deepLinking(true)
//            .displayOperationId(false)
//            .defaultModelsExpandDepth(1)
//            .defaultModelExpandDepth(1)
//            .defaultModelRendering(ModelRendering.EXAMPLE)
//            .displayRequestDuration(false)
//            .docExpansion(DocExpansion.NONE)
//            .filter(false)
//            .maxDisplayedTags(null)
//            .operationsSorter(OperationsSorter.ALPHA)
//            .showExtensions(false)
//            .showCommonExtensions(false)
//            .tagsSorter(TagsSorter.ALPHA)
//            .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
//            .validatorUrl(null)
//            .build();
//    }

    @Bean
    @ConditionalOnMissingBean(WebSecureConfig.class)
    public OpenAPI webBaseOpenAPI(@Value("${springdoc.version}") String appVersion) {
        return new OpenAPI()
                .info(new Info().title("Web Base API")
                        .description("this is the base api")
                        .version(appVersion)
                        .license(new License().name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("google")
                        .url("https://www.google.com"));
    }

    @Bean
    @ConditionalOnBean(WebSecureConfig.class)
    public OpenAPI securedOpenAPI(@Value("${springdoc.version}") String appVersion) {
        return new OpenAPI()
                .info(new Info().title("Web Base API")
                        .description("this is the base api")
                        .version(appVersion)
                        .license(new License().name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0")))
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
