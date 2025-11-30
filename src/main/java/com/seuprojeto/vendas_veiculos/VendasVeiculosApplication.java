package com.seuprojeto.vendas_veiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.seuprojeto.vendas_veiculos", "com.seuprojeto.vendasveiculos"})
@EntityScan(basePackages = {"com.seuprojeto.vendas_veiculos", "com.seuprojeto.vendasveiculos"})
@EnableJpaRepositories(basePackages = {"com.seuprojeto.vendas_veiculos", "com.seuprojeto.vendasveiculos"})
public class VendasVeiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendasVeiculosApplication.class, args);
	}

}
