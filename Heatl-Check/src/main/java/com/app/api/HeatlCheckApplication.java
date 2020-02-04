package com.app.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.google.common.base.Predicates;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAdminServer
@EnableSwagger2
@EnableJpaAuditing
public class HeatlCheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeatlCheckApplication.class, args);
	}

}
