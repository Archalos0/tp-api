package com.api.product.api.product.controller;

import com.api.product.api.product.dto.ContractDTO;
import com.api.product.api.product.exception.ContractNotFoundException;
import com.api.product.api.product.model.Contract;
import com.api.product.api.product.service.ContractService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class ContractController {

    private ContractService contractService;


    ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/contracts")
    public ResponseEntity<List<ContractDTO>> getContracts(){
        List<Contract> contracts = contractService.getContracts();
        List<ContractDTO> contractsDTO = contracts.stream().map(ContractDTO::from).collect(Collectors.toList());
        return new ResponseEntity<>(contractsDTO, HttpStatus.OK);
    }

    @PostMapping("/contracts")
    public ResponseEntity<ContractDTO> newContract(@RequestBody final ContractDTO contractDTO){
        Contract newContract = contractService.addContract(Contract.from(contractDTO));
        return new ResponseEntity<>(ContractDTO.from(newContract), HttpStatus.OK);
    }


}
