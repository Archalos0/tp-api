package com.api.product.api.product.dto;

import com.api.product.api.product.model.Customer;
import lombok.Data;

import java.util.Objects;

@Data
public class CustomerDTO {

    private Long id_client;
    private String nom;
    private PlainContractDTO contrat;

    public static CustomerDTO from(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId_client(customer.getID());
        customerDTO.setNom(customer.getNom());
        if(Objects.nonNull(customer.getContrat())){
            customerDTO.setContrat(PlainContractDTO.from(customer.getContrat()));
        }

        return customerDTO;
    }
}
