package com.api.product.api.product.controller;

import com.api.product.api.product.dto.CustomerDTO;
import com.api.product.api.product.dto.ProductCustomerDTO;
import com.api.product.api.product.model.Customer;
import com.api.product.api.product.model.Product;
import com.api.product.api.product.service.CustomerService;
import com.api.product.api.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductCustomerController {

    private ProductService productService;
    private CustomerService customerService;

    ProductCustomerController(ProductService productService, CustomerService customerService){
        this.productService = productService;
        this.customerService = customerService;
    }

    @GetMapping("/customers/{id_client}/products")
    public ResponseEntity<List<ProductCustomerDTO>> getProductsCustomers(@PathVariable Long id_client){
        List<Product> products = productService.getProducts();
        Customer customer = customerService.getOneCustomer(id_client);

        List<ProductCustomerDTO> productCustomersDTO = products.stream().map(product -> ProductCustomerDTO.from(product, customer.getContrat().getMarge())).collect(Collectors.toList());
        return new ResponseEntity<>(productCustomersDTO, HttpStatus.OK);
    }
}
