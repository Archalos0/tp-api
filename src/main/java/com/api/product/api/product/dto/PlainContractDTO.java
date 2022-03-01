package com.api.product.api.product.dto;

import com.api.product.api.product.model.Contract;
import lombok.Data;

import java.util.Date;

@Data
public class PlainContractDTO {

    private Long id_contrat;
    private String nom;
    private Date date_debut;
    private Date date_fin;
    private float marge;

    public static PlainContractDTO from(Contract contract){
        PlainContractDTO plainContractDTO = new PlainContractDTO();

        plainContractDTO.setId_contrat(contract.getId_contrat());
        plainContractDTO.setNom(contract.getNom());
        plainContractDTO.setDate_debut(contract.getDate_debut());
        plainContractDTO.setDate_fin(contract.getDate_fin());
        plainContractDTO.setMarge(contract.getMarge());

        return plainContractDTO;
    }
}
