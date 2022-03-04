package com.api.product.api.product.controller;

import com.api.product.api.product.dto.ContractDTO;
import com.api.product.api.product.dto.CustomerDTO;
import com.api.product.api.product.dto.ProductCustomerDTO;
import com.api.product.api.product.exception.CustomerNotFoundException;
import com.api.product.api.product.exception.ProductNotFoundException;
import com.api.product.api.product.model.Contract;
import com.api.product.api.product.model.Customer;
import com.api.product.api.product.model.Product;
import com.api.product.api.product.repository.ContractRepository;
import com.api.product.api.product.repository.CustomerRepository;
import com.api.product.api.product.service.CustomerService;
import com.api.product.api.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getCustomers(){
        List<Customer> customers = customerService.getCustomers();
        List<CustomerDTO> customersDTO = customers.stream().map(CustomerDTO::from).collect(Collectors.toList());
        return new ResponseEntity<>(customersDTO, HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerDTO> getOneCustomer(@PathVariable final Long id) {
        Customer customer = customerService.getOneCustomer(id);
        return new ResponseEntity<>(CustomerDTO.from(customer), HttpStatus.OK);
    }

    @GetMapping("/customers/{id_client}/products")
    public ResponseEntity<List<ProductCustomerDTO>> getProductsCustomers(@PathVariable Long id_client){
        List<Product> products = productService.getProducts();
        Customer customer = customerService.getOneCustomer(id_client);

        List<ProductCustomerDTO> productCustomersDTO = products.stream().map(product -> ProductCustomerDTO.from(product, customer.getContrat().getMarge())).collect(Collectors.toList());
        return new ResponseEntity<>(productCustomersDTO, HttpStatus.OK);
    }

    @GetMapping("/customers/{id_client}/products/{id_product}")
    public ResponseEntity<ProductCustomerDTO> getOneProductCustomer(@PathVariable Long id_client, @PathVariable Long id_product){
        Product product = productService.getOneProduct(id_product);
        Customer customer = customerService.getOneCustomer(id_client);

        return new ResponseEntity<>(ProductCustomerDTO.from(product, customer.getContrat().getMarge()), HttpStatus.OK);
    }


}
