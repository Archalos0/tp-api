package com.api.product.api.product.service;

import com.api.product.api.product.model.Contract;
import com.api.product.api.product.repository.ContractRepository;
import com.api.product.api.product.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ContractService {

    private final ContractRepository contractRepository;
    private final CustomerService customerService;

    @Autowired
    public ContractService(ContractRepository contractRepository, CustomerService customerService){
        this.contractRepository = contractRepository;
        this.customerService = customerService;
    }

    public List<Contract> getContracts(){
        return StreamSupport
                .stream(contractRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Contract addContract(Contract contract){
        return contractRepository.save(contract);
    }

}
