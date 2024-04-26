package com.navin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.navin.*")
@EnableJpaRepositories("com.navin.service")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
