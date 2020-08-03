package pl.zulwik.driver.config;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    private final Logger log = LoggerFactory.getLogger(SwaggerConfig.class);
    private static final String BASIC_AUTH = "basicAuth";
    private static final String BEARER_AUTH = "Bearer";
    public static final String DEFAULT_INCLUDE_PATTERN = "/*";

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Driver api")
                .description("Driver advices and training exercises")
                .version("1.0.0")
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo())
                .securitySchemes(securitySchemes())
                .securityContexts(Collections.singletonList(securityContext()));
    }
    private List<SecurityScheme> securitySchemes() {
        return List.of(new ApiKey(BEARER_AUTH, "Authorization", "header"));
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(List.of(basicAuthReference(), bearerAuthReference())).forPaths(PathSelectors.ant("/advice/**")).build();
    }


    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(
                new SecurityReference("JWT", authorizationScopes));
    }

    private SecurityReference bearerAuthReference() {
        return new SecurityReference(BEARER_AUTH, new AuthorizationScope[0]);
    }
    private SecurityReference basicAuthReference() {
        return new SecurityReference(BASIC_AUTH, new AuthorizationScope[0]);
    }
}
