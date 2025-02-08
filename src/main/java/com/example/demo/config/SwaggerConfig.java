package com.example.demo.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
        description = "fvhgdsv",
        summary = "hvgvdvadvvdhvag",
        termsOfService = "T&V",
        title = "cxfggfdcacd",
        contact = @Contact(
            name = "dgdgavhgdvavfdv",
            email = "sanyyyghvc@gmail.com"
        ),
        version = "V1"
    ),
    servers = {
        @Server(
            url = "http://localhost:8090",
            description = "PRODUCT SERVER."
        ),
        @Server(
            url = "http://localhost:8081",
            description = "DEV Server"
        )
    }
)
@Configuration
 class SwaggerConfig {
	
	
	
	

}
