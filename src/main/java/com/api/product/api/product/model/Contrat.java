package com.api.product.api.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Contrat {

    private @Id @GeneratedValue Long id_contrat;
    public String nom;
    public Date date_debut;
    public Date date_fin;
    public float marge;

    Contrat() {}

    Contrat(String nom, Date date_debut, Date date_fin, float marge) {
        this.nom = nom;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.marge = marge;
    }

    public Long GetID(){
        return id_contrat;
    }

}
