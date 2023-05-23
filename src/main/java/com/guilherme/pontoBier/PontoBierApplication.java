package com.guilherme.pontoBier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.guilherme.pontoBier.model")
@EnableJpaRepositories("com.guilherme.pontoBier.repositorie")
public class PontoBierApplication {

	public static void main(String[] args) {
		SpringApplication.run(PontoBierApplication.class, args);

	}

}
