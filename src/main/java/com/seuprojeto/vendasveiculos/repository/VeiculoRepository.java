package com.seuprojeto.vendasveiculos.repository;

import com.seuprojeto.vendasveiculos.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Marca a interface como um componente de repositório
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    // JpaRepository já fornece métodos CRUD básicos (save, findById, findAll, deleteById)

    // Você pode adicionar métodos de consulta personalizados aqui, se necessário.
    // Ex: List<Veiculo> findByMarca(String marca);
    // Ex: List<Veiculo> findByDisponivelParaVendaTrue();
}
