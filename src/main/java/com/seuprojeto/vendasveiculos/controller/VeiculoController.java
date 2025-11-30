package com.seuprojeto.vendasveiculos.controller;

import com.seuprojeto.vendasveiculos.model.Veiculo;
import com.seuprojeto.vendasveiculos.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marca a classe como um controlador REST
@RequestMapping("/api/veiculos") // Define o prefixo da URL para todos os endpoints desta classe
@CrossOrigin(origins = "http://localhost:8080") // Permite requisições do frontend local
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    // Endpoint para criar um novo veículo (CREATE)
    @PostMapping
    public ResponseEntity<Veiculo> criarVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo novoVeiculo = veiculoService.salvarVeiculo(veiculo);
        return new ResponseEntity<>(novoVeiculo, HttpStatus.CREATED);
    }

    // Endpoint para buscar todos os veículos (READ ALL)
    @GetMapping
    public ResponseEntity<List<Veiculo>> buscarTodosVeiculos() {
        List<Veiculo> veiculos = veiculoService.buscarTodosVeiculos();
        return new ResponseEntity<>(veiculos, HttpStatus.OK);
    }

    // Endpoint para buscar um veículo por ID (READ BY ID)
    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarVeiculoPorId(@PathVariable Long id) {
        return veiculoService.buscarVeiculoPorId(id)
                .map(veiculo -> new ResponseEntity<>(veiculo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para atualizar um veículo existente (UPDATE)
    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        try {
            Veiculo veiculoAtualizado = veiculoService.atualizarVeiculo(id, veiculo);
            return new ResponseEntity<>(veiculoAtualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para deletar um veículo (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable Long id) {
        veiculoService.deletarVeiculo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
