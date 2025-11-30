package com.seuprojeto.vendasveiculos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Marca esta classe como uma entidade JPA
@Table(name = "veiculos") // Define o nome da tabela no BD
@Data // Gera getters, setters, toString, equals e hashCode (Lombok)
@NoArgsConstructor // Gera construtor sem argumentos (Lombok)
@AllArgsConstructor // Gera construtor com todos os argumentos (Lombok)
public class Veiculo {

    @Id // Marca o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática de ID
    private Long id;

    @Column(nullable = false) // Campo não pode ser nulo
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private Integer ano;

    @Column(nullable = false)
    private Double preco;

    private String cor;
    private String tipoCarroceria; // Ex: Sedan, SUV, Hatch, Picape
    private String placa; // Pode ser único, se houver necessidade
    private boolean disponivelParaVenda = true; // Status do veículo

    // Você pode adicionar mais atributos conforme a necessidade do desafio,
    // como quilometragem, histórico de manutenção, etc.
}
