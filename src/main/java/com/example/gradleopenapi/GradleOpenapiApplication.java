package com.example.gradleopenapi;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "OpenAPIProject", version = "2.0",description = "OpenApi application"))
public class GradleOpenapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradleOpenapiApplication.class, args);
	}

}
