package com.lsm.ws.offer.configuration.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    private static final String LSM_OFFER_GROUP = "lsm-offer";
    private static final String LSM_OFFER_PATH = "/v1/api/offer/**";

    @Bean
    public GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder()
                             .group(LSM_OFFER_GROUP)
                             .pathsToMatch(LSM_OFFER_PATH)
                             .build();
    }

    @Bean
    public OpenAPI openAPI() {
        var openApi = new OpenAPI().info(new Info().description("LeaseMate offer microservice")
                                                   .title("Offer microservice"))
                                   .addServersItem(new Server().url("/"));
        addAuthBearer(openApi);
        return openApi;
    }

    private void addAuthBearer(OpenAPI openAPI) {
        openAPI.addSecurityItem(new SecurityRequirement().addList("authBearer"))
               .components(new Components().addSecuritySchemes("authBearer",
                       new SecurityScheme().name("authBearer")
                                           .type(SecurityScheme.Type.HTTP)
                                           .scheme("bearer")
                                           .bearerFormat("JWT")));
    }
}
