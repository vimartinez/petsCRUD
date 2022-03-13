package ar.com.pets.crud.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("ar.com.pets.crud.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo())
				;
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"CRUD de super mascotas",
				"Test",
				"1.0",
				"https://github.com",
				new Contact("CRUD de Mascotas", "https://github.com/","pp@mail.com"),
				"LICENSE GNU General Publice License",
				"https://es.wikipedia.org/wiki/GNU_General_Public_License",
				Collections.emptyList()
				);
	}
}
