package com.app.api.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class ApplicationController {

	@Bean
	public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2)
	    .select()
	    .apis(RequestHandlerSelectors.any())
	    .paths(PathSelectors.any())
	    .paths(Predicates.not(PathSelectors.regex("/error.*")))
	    .paths(Predicates.not(PathSelectors.regex("/admin.*")))
	    .paths(Predicates.not(PathSelectors.regex("/actuator.*")))
	    .build();
	}

}
