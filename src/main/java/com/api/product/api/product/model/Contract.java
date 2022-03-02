package com.api.product.api.product.model;



import com.api.product.api.product.dto.ContractDTO;
import lombok.Data;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "contrat")
public class Contract {

    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id_contrat;
    private String nom;
    private Date date_debut;
    private Date date_fin;
    private float marge;

    @OneToMany( targetEntity=Customer.class, mappedBy="contrat" )
    private List<Customer> customers = new ArrayList<>();

    public Contract() {}

    Contract(String nom, Date date_debut, Date date_fin, float marge) {
        this.nom = nom;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.marge = marge;
    }

    public static Contract from(ContractDTO contractDTO) {
        Contract contract = new Contract();
        contract.setId_contrat(contractDTO.getId_contrat());
        contract.setNom(contractDTO.getNom());
        contract.setDate_debut(contract.getDate_debut());
        contract.setDate_fin(contract.getDate_fin());
        contract.setMarge(contractDTO.getMarge());

        return contract;
    }
}
