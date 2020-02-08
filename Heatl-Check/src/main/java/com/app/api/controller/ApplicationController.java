package com.app.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@Controller
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
	    .paths(Predicates.not(PathSelectors.regex("/")))
	    .build();
	}
	
	@Value("${uri}")
	private String hostUrl;
	
	@GetMapping("/")
	public String redirectToAdmin(HttpServletRequest request) {
		String homeUrl = hostUrl;
		return "redirect:".concat(homeUrl).concat("/admin").concat("/wallboard");
	}

}
