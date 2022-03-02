package com.api.product.api.product.dto;

import com.api.product.api.product.model.Contract;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ContractDTO {

    private Long id_contrat;
    private String nom;
    private String date_debut;
    private String date_fin;
    private float marge;
    private List<CustomerDTO> customersDTO = new ArrayList<>();

    public static ContractDTO from(Contract contract){
        ContractDTO contractDTO = new ContractDTO();

        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yy");

        contractDTO.setId_contrat(contract.getId_contrat());
        contractDTO.setNom(contract.getNom());
        contractDTO.setDate_debut(formater.format(contract.getDate_debut()));
        contractDTO.setDate_fin(formater.format(contract.getDate_fin()));
        contractDTO.setMarge(contract.getMarge());
        contractDTO.setCustomersDTO(contract.getCustomers().stream().map(CustomerDTO::from).collect(Collectors.toList()));

        return contractDTO;
    }

}
