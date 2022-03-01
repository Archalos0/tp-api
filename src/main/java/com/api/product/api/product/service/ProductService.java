package com.api.product.api.product.service;

import com.api.product.api.product.exception.CustomerNotFoundException;
import com.api.product.api.product.exception.ProductNotFoundException;
import com.api.product.api.product.model.Customer;
import com.api.product.api.product.model.Product;
import com.api.product.api.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return StreamSupport
                .stream(productRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Product getOneProduct(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

}
