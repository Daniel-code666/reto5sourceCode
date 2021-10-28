package com.reto3.sa.practica.reto3grupo05g8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.reto3.sa.practica.reto3grupo05g8"})
public class Reto3grupo05g8Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto3grupo05g8Application.class, args);
	}

}
