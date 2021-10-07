package com.github.daniMagaiver.qosc.api.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/***
 * /** Parametrizações para uso do Swagger no Projeto.
 * 
 * URL padrão Swagger: http://localhost:8080/swagger-ui.html
 * 
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
	public static final ApiInfo defaultApiInfo = new ApiInfo("Qosc-Api",
			"QOSC (Quality of Services for Cyber Physical Systems) - v1 - Front - https://danimagaiver.github.io/qosc/",
			"v1", "", new Contact("Danilo da Silva Fernandes", "", "danilo.silfer@gmail.com"), "", "",
			Collections.emptyList());

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.github.daniMagaiver.qosc.api.controller"))
				.paths(PathSelectors.any())   
				.build();

	}


	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
