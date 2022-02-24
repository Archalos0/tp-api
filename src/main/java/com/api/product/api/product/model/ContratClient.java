package com.api.product.api.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ContratClient {

    private @Id @GeneratedValue Long id_contrat_client;
    public Long id_client;
    public Long id_contrat;

    ContratClient() {}

    ContratClient(Long id_client, Long id_contrat) {
        this.id_client = id_client;
        this.id_contrat = id_contrat;
    }

    public Long GetID() {
        return id_contrat_client;
    }
}
