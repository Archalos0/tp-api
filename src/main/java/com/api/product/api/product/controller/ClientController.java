package com.api.product.api.product.controller;

import com.api.product.api.product.model.Article;
import com.api.product.api.product.model.Client;
import com.api.product.api.product.repository.ArticleRepository;
import com.api.product.api.product.repository.ClientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class ClientController {

    private ClientRepository repository;

    ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/clients")
    List<Client> all() {
        return repository.findAll();
    }

    @PostMapping("/client")
    Client newClient(@RequestBody Client newClient){
        return repository.save(newClient);
    }

}
