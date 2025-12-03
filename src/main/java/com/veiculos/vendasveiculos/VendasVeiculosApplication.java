package com.veiculos.vendasveiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.veiculos.vendasveiculos"})
@EntityScan(basePackages = {"com.veiculos.vendasveiculos"})
@EnableJpaRepositories(basePackages = {"com.veiculos.vendasveiculos"})
public class VendasVeiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendasVeiculosApplication.class, args);
	}

}
