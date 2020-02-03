package com.app.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
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
