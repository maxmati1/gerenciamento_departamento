package com.bn.ex8.controllers;

import com.bn.ex8.models.DepartamentoModel;
import com.bn.ex8.services.DepartamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    private final DepartamentoService service;

    public DepartamentoController(DepartamentoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoModel>> findAll() {
        List<DepartamentoModel> lista = service.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<DepartamentoModel> criarDepartamento(@RequestBody DepartamentoModel departamento) {
        DepartamentoModel novo = service.criarDepartamento(departamento);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novo.getId())
                .toUri();
        return ResponseEntity.created(uri).body(novo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoModel> buscarPorId(@PathVariable Long id) {
        DepartamentoModel departamento = service.buscarPorId(id);
        return ResponseEntity.ok(departamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDepartamento(@PathVariable Long id) {
        service.deletarDepartamento(id);
        return ResponseEntity.noContent().build();
    }
}