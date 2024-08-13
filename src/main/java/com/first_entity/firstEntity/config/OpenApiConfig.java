package com.first_entity.firstEntity.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Haythem",
                        email = "khiarih06@gmail.com",
                        url = "https://haythemSchool.com"
                ),
                description = "OpenApi documentation for Spring Boot Application",
                title = "OpenApi specification - Haythem",
                version = "1.0",
                license = @License(
                        name = "Licence name",
                        url = "https://haythemSchool.com"
                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8090/api/v1"
                ),
                @Server(
                        description = "PROD ENV",
                        url = "https://haythemSchool.com"
                )
        }
)
public class OpenApiConfig {
}
