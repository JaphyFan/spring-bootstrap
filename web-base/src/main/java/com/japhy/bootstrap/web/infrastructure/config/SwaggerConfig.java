package com.japhy.bootstrap.web.infrastructure.config;

import static java.util.Collections.singletonList;


import com.fasterxml.classmate.TypeResolver;
import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

/**
 * @author Japhy
 * @since 2021/1/10 09:35
 */
@Configuration
//@Profile("swagger")
public class SwaggerConfig {

    @Bean
    public Docket createAccountApi() {
        return new Docket(DocumentationType.OAS_30)
            .groupName("user-api")
            .apiInfo(apiInfo())
            .produces(Sets.newHashSet("application/json"))
            .protocols(Sets.newHashSet("http"))
            .securityContexts(singletonList(securityContext()))
            .securitySchemes(singletonList(apiKey()))
            .select()
            .paths(PathSelectors.ant("/**/users/**"))
            .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
            .build();
    }

    @Bean
    public Docket createPublicApi() {
        return new Docket(DocumentationType.OAS_30)
            .groupName("public-api")
            .apiInfo(apiInfo())
            .produces(Sets.newHashSet("application/json"))
            .protocols(Sets.newHashSet("http"))
            .select()
            .paths(PathSelectors.ant("/**/public/**"))
            .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
            .build();
    }

    @Bean
    public Docket createOrderApi() {
        return new Docket(DocumentationType.OAS_30)
            .groupName("order-api").apiInfo(apiInfo())
            .produces(Sets.newHashSet("application/json"))
            .securityContexts(singletonList(securityContext()))
            .securitySchemes(singletonList(apiKey()))
            .select()
            .paths(PathSelectors.ant("/**/orders/**"))
            .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).build();
    }

    @Bean
    public Docket createFeatureApi() {
        return new Docket(DocumentationType.OAS_30)
            .groupName("feature-api").apiInfo(apiInfo())
            .produces(Sets.newHashSet("application/json"))
            .securityContexts(singletonList(securityContext()))
            .securitySchemes(singletonList(apiKey()))
            .select()
            .paths(PathSelectors.ant("/**/features/**"))
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

    //FIXME: security 配置 japhy 2021/1/21
//    @Autowired
//    private TypeResolver typeResolver;
//
    private ApiKey apiKey() {
        return new ApiKey("Authorization", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
            .securityReferences(defaultAuth())
            .operationSelector(operationContext -> operationContext.requestMappingPattern().startsWith("/api/"))
            .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
            = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return singletonList(
            new SecurityReference("Authorization", authorizationScopes));
    }
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
}
