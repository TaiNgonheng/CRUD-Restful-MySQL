package Restful_Webservice.Spring.Boot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.security.PublicKey;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Rest API Documentation",
				description = "Spring Boot Rest API Documentation Description",
				version = "v6.0",
				contact = @Contact(
						name = "heng",
						email = "heng@gmail.com",
						url = "https://www.java.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://www.java.com/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot User management Documentation",
				url = "http://www.java.com"
		)
)
public class Application {
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
