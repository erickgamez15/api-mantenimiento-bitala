package com.bitala.apiprueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApiPruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPruebaApplication.class, args);
	}

}
