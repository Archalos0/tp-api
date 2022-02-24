package com.api.product.api.product.controller;

import com.api.product.api.product.model.Article;
import com.api.product.api.product.repository.ArticleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
public class ProductController {

    private ArticleRepository repository;

    ProductController(ArticleRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    List<Article> all() {
        return repository.findAll();
    }

    @PostMapping("url/product")
    Article newProduct(@RequestBody Article newArticle){
        return repository.save(newArticle);
    }
}
