package com.veiculos.vendasveiculos.service;

import com.veiculos.vendasveiculos.model.Veiculo;
import com.veiculos.vendasveiculos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marca a classe como um componente de serviço
public class VeiculoService {

    @Autowired // Injeção de dependência do repositório
    private VeiculoRepository veiculoRepository;

    // CREATE
    public Veiculo salvarVeiculo(Veiculo veiculo) {
        // Validações de negócio podem vir aqui antes de salvar
        // Ex: verificar se a placa já existe, se o ano é válido
        return veiculoRepository.save(veiculo);
    }

    // READ All
    public List<Veiculo> buscarTodosVeiculos() {
        return veiculoRepository.findAll();
    }

    // READ by ID
    public Optional<Veiculo> buscarVeiculoPorId(Long id) {
        return veiculoRepository.findById(id);
    }

    // UPDATE
    public Veiculo atualizarVeiculo(Long id, Veiculo veiculoAtualizado) {
        return veiculoRepository.findById(id).map(veiculoExistente -> {
            veiculoExistente.setMarca(veiculoAtualizado.getMarca());
            veiculoExistente.setModelo(veiculoAtualizado.getModelo());
            veiculoExistente.setAno(veiculoAtualizado.getAno());
            veiculoExistente.setPreco(veiculoAtualizado.getPreco());
            veiculoExistente.setCor(veiculoAtualizado.getCor());
            veiculoExistente.setTipoCarroceria(veiculoAtualizado.getTipoCarroceria());
            veiculoExistente.setPlaca(veiculoAtualizado.getPlaca());
            veiculoExistente.setDisponivelParaVenda(veiculoAtualizado.isDisponivelParaVenda());
            // Atualize outros campos conforme necessário
            return veiculoRepository.save(veiculoExistente);
        }).orElseThrow(() -> new RuntimeException("Veículo não encontrado com ID: " + id));
    }

    // DELETE
    public void deletarVeiculo(Long id) {
        veiculoRepository.deleteById(id);
    }
}
