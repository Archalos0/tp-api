package com.api.product.api.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {

    private @Id @GeneratedValue Long id_client;
    public String nom;

    Client() {}

    Client(String nom) {
        this.nom = nom;
    }

    public Long GetID(){
        return id_client;
    }
}
