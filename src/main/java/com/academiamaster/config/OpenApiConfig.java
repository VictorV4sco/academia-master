package com.academiamaster.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

	@Bean
	OpenAPI MasterAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Master API").
						description("Cash Register Control")
						.version("v0.0.1")
				.license(new License()
						.name("GPL-3.0 ")
						.url("https://github.com/VictorV4sco/academia-master")));
	}
}
