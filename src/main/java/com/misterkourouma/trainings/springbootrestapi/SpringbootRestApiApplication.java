package com.misterkourouma.trainings.springbootrestapi;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Rest API Documentation",
				description = "Spring Boot Rest API Documentation",
				version = "1.0",
				contact = @Contact(
						name = "AK",
						email = "ak@gmail.com",
						url = "https://misterkourouma.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://misterkourouma.com/licence"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot User Management Documentation",
				url = "https://misterkourouma.com/user_management.html"
		)
)
public class SpringbootRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestApiApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
