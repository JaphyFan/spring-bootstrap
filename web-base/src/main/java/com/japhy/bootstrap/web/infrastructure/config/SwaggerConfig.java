package com.japhy.bootstrap.web.infrastructure.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Japhy
 * @since 2021/1/10 09:35
 */
@Configuration
//@Profile("swagger")
public class SwaggerConfig {

//     @Bean
//     public Docket createAccountApi() {
//         return new Docket(DocumentationType.OAS_30)
//             .groupName("user-api")
//             .apiInfo(apiInfo())
//             .produces(Sets.newHashSet("application/json"))
//             .protocols(Sets.newHashSet("http"))
//             .securityContexts(singletonList(securityContext()))
//             .securitySchemes(singletonList(apiKey()))
//             .select()
//             .paths(PathSelectors.ant("/**/users/**"))
//             .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
//             .build();
//     }
//
//     @Bean
//     public Docket createPublicApi() {
//         return new Docket(DocumentationType.OAS_30)
//             .groupName("public-api")
//             .apiInfo(apiInfo())
//             .produces(Sets.newHashSet("application/json"))
//             .protocols(Sets.newHashSet("http"))
//             .select()
//             .paths(PathSelectors.ant("/**/public/**"))
//             .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
//             .build();
//     }
//
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
//     @Bean
//     public Docket createFeatureApi() {
//         return new Docket(DocumentationType.OAS_30)
//             .groupName("feature-api").apiInfo(apiInfo())
//             .produces(Sets.newHashSet("application/json"))
//             .securityContexts(singletonList(securityContext()))
//             .securitySchemes(singletonList(apiKey()))
//             .select()
//             .paths(PathSelectors.ant("/**/features/**"))
//             .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).build();
//     }
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
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("SpringShop API")
                        .description("Spring shop sample application")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"));
    }

    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group("springshop-admin")
                .pathsToMatch("**/users/**")
                .build();
    }

}
