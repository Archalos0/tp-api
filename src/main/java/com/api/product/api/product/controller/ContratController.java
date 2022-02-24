package com.api.product.api.product.controller;

import com.api.product.api.product.model.Contrat;
import com.api.product.api.product.repository.ContratRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class ContratController {

    private ContratRepository repository;

    ContratController(ContratRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/contrats")
    List<Contrat> all() {
        return repository.findAll();
    }

    @PostMapping("/contrat")
    Contrat newContrat(@RequestBody Contrat newContrat){
        return repository.save(newContrat);
    }
}
