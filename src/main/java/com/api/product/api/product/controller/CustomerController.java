package com.api.product.api.product.controller;

import com.api.product.api.product.dto.ContractDTO;
import com.api.product.api.product.dto.CustomerDTO;
import com.api.product.api.product.exception.CustomerNotFoundException;
import com.api.product.api.product.exception.ProductNotFoundException;
import com.api.product.api.product.model.Contract;
import com.api.product.api.product.model.Customer;
import com.api.product.api.product.model.Product;
import com.api.product.api.product.repository.ContractRepository;
import com.api.product.api.product.repository.CustomerRepository;
import com.api.product.api.product.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {


    private CustomerService customerService;

    CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getContracts(){
        List<Customer> customers = customerService.getCustomers();
        List<CustomerDTO> customersDTO = customers.stream().map(CustomerDTO::from).collect(Collectors.toList());
        return new ResponseEntity<>(customersDTO, HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerDTO> getOneCustomer(@PathVariable final Long id) {
        Customer customer = customerService.getOneCustomer(id);
        return new ResponseEntity<>(CustomerDTO.from(customer), HttpStatus.OK);
    }


    /*private CustomerRepository repository;


    CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customers")
    List<Customer> all() {
        return repository.findAll();
    }

    @GetMapping("/customers/{id}")
    Customer one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @PostMapping("/customers")
    Customer newClient(@RequestBody Customer newClient){
        return repository.save(newClient);
    }

    @PutMapping("/customers/{id}")
    Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {

        return repository.findById(id)
                .map(customer -> {
                    customer.setNom(newCustomer.getNom());
                    customer.setContrat(newCustomer.getContrat());
                    return repository.save(customer);
                })
                .orElseGet(() -> {
                    newCustomer.setID(id);
                    return repository.save(newCustomer);
                });
    }

    @DeleteMapping("/customers/{id}")
    void deleteCustomer(@PathVariable Long id) {
        repository.deleteById(id);
    }*/

}
