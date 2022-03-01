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

@RestController
public class ContractController {

    private ContractService contractService;

    /*ContractController(ContractRepository repository) {
        this.repository = repository;
    }*/

    ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/contracts")
    public ResponseEntity<List<ContractDTO>> getContracts(){
        List<Contract> contracts = contractService.getContracts();
        List<ContractDTO> contractsDTO = contracts.stream().map(ContractDTO::from).collect(Collectors.toList());
        return new ResponseEntity<>(contractsDTO, HttpStatus.OK);
    }

    /*@GetMapping("/contracts")
    List<Contract> all() {
        return repository.findAll();
    }

    @GetMapping("/contracts/{id}")
    Contract one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ContractNotFoundException(id));
    }

    @PostMapping("/contracts")
    Contract newContract(@RequestBody Contract newContract){
        return repository.save(newContract);
    }*/

    @PostMapping("/contracts")
    public ResponseEntity<ContractDTO> newContract(@RequestBody final ContractDTO contractDTO){
        Contract newContract = contractService.addContract(Contract.from(contractDTO));
        return new ResponseEntity<>(ContractDTO.from(newContract), HttpStatus.OK);
    }

    /*@PutMapping("/contracts/{id}")
    Contract replaceContract(@RequestBody Contract newContract, @PathVariable Long id) {

        return repository.findById(id)
                .map(contract -> {
                    contract.setNom(newContract.getNom());
                    contract.setDate_debut(newContract.getDate_debut());
                    contract.setDate_fin(newContract.getDate_fin());
                    contract.setMarge(newContract.getMarge());
                    return repository.save(contract);
                })
                .orElseGet(() -> {
                    newContract.setID(id);
                    return repository.save(newContract);
                });
    }

    @DeleteMapping("/contracts/{id}")
    void deleteContract(@PathVariable Long id) {
        repository.deleteById(id);
    }*/
}
