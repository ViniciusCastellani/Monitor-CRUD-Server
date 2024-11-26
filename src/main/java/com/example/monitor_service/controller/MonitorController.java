package com.example.monitor_service.controller;

import com.example.monitor_service.dao.MonitorDao;
import com.example.monitor_service.model.Monitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monitor")  // Define a URL base para todos os endpoints de Monitor
@CrossOrigin  // Permite requisições do frontend específico
public class MonitorController {

    @Autowired
    private MonitorDao dao;

    // Endpoint para listar todos os monitores
    @GetMapping
    public List<Monitor> listar() {
        return dao.listar();
    }

    // Endpoint para obter um monitor específico pelo ID
    @GetMapping("/{id}")
    public Monitor obter(@PathVariable int id) {
        return dao.obter(id);
    }

    // Endpoint para incluir um novo monitor
    @PostMapping
    public Monitor incluir(@RequestBody Monitor monitor) {
        return dao.incluir(monitor);  // Retorna o monitor com o ID atualizado
    }

    @PutMapping
    public Monitor atualizar(@RequestBody Monitor monitor) {
        return dao.alterar(monitor);
    }

    // Endpoint para excluir um monitor pelo ID
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable int id) {
        dao.excluir(id);
    }
}