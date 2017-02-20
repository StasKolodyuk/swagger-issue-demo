package com.swagger.issue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.swagger.web.UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS;

@EnableSwagger2
@SpringBootApplication
public class SwaggerIssueDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerIssueDemoApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.swagger.issue.controller"))
				.paths(PathSelectors.any())
				.build()
				.useDefaultResponseMessages(false)
				.apiInfo(apiInfo());
	}

	@Bean
	public UiConfiguration uiConfig() {
		return new UiConfiguration(null, "none", "alpha", "schema", DEFAULT_SUBMIT_METHODS, true, true);
	}

	@Bean
	public ApiInfo apiInfo() {
		return new ApiInfo("Echo REST API", "Echo REST API", null, null, new Contact(null, null, null), null, null);
	}
}
