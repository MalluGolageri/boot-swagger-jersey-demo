package com.sapient.user;

import javax.annotation.PostConstruct;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@Component
public class JerseyConfig extends ResourceConfig {
    @Value("${spring.jersey.application-path:/}")
    private String apiPath;

    public JerseyConfig() {
        this.registerEndpoints();
    }

    @PostConstruct
    public void init() {
        this.configureSwagger();

    }

    private void registerEndpoints() {
        this.register(UserController.class);
    }

    private void configureSwagger() {
        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);

        BeanConfig config = new BeanConfig();
        config.setConfigId("springBoot-jersey-swagger-example ");
        config.setTitle("Spring Boot + Jersey + Swagger Example version-1 & version-2 ");
        config.setVersion("v1");
        config.setContact("Mallu");
        config.setSchemes(new String[]{"http", "https"});
        config.setBasePath(this.apiPath);
        config.setResourcePackage("com.sapient.user");
        config.setPrettyPrint(true);
        config.setScan(true);


    }
}