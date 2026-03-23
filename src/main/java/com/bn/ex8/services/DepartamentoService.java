package com.bn.ex8.services;

import com.bn.ex8.models.DepartamentoModel;
import com.bn.ex8.repositories.DepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    private final DepartamentoRepository repository;

    public DepartamentoService(DepartamentoRepository repository) {
        this.repository = repository;
    }

    public DepartamentoModel criarDepartamento(DepartamentoModel departamento) {
        return repository.save(departamento);
    }

    public List<DepartamentoModel> findAll() {
        return repository.findAll();
    }

    public DepartamentoModel buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletarDepartamento(Long id) {
        repository.deleteById(id);
    }
}