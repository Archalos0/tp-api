package com.api.product.api.product.controller;

import com.api.product.api.product.exception.ProductNotFoundException;
import com.api.product.api.product.model.Product;
import com.api.product.api.product.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class ProductController {

    private ProductRepository repository;

    ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    List<Product> all() {
        return repository.findAll();
    }

    @GetMapping("/products/{id}")
    Product one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PostMapping("/products")
    Product newProduct(@RequestBody Product newArticle){
        return repository.save(newArticle);
    }

    @PutMapping("/products/{id}")
    Product replaceProduct(@RequestBody Product newArticle, @PathVariable Long id) {

        return repository.findById(id)
                .map(article -> {
                    article.setDesignation(newArticle.getDesignation());
                    article.setPrix(newArticle.getPrix());
                    return repository.save(article);
                })
                .orElseGet(() -> {
                    newArticle.setID(id);
                    return repository.save(newArticle);
                });
    }

    @DeleteMapping("/products/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
