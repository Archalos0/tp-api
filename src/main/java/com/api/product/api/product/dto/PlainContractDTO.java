package com.api.product.api.product.dto;

import com.api.product.api.product.model.Contract;
import lombok.Data;

import java.util.Date;

@Data
public class PlainContractDTO {

    private Long id_contrat;
    private String nom;
    private float marge;

    public static PlainContractDTO from(Contract contract){
        PlainContractDTO plainContractDTO = new PlainContractDTO();

        plainContractDTO.setId_contrat(contract.getId_contrat());
        plainContractDTO.setNom(contract.getNom());
        plainContractDTO.setMarge(contract.getMarge());

        return plainContractDTO;
    }
}
