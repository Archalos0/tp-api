package com.api.product.api.product.model;


import javax.persistence.*;

@Entity
@Table(name = "client")
public class Customer {

    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id_client;
    private String nom;

    @ManyToOne
    @JoinColumn(name = "id_contrat", referencedColumnName = "id_contrat")
    private Contract contrat;

    public Customer() {}

    public Customer(Long id_client, String nom) {
        this.id_client = id_client;
        this.nom = nom;
    }

    public Customer(Long id_client, String nom, Contract contrat) {
        this(id_client, nom);
        this.contrat = contrat;
    }



    /*Customer(String nom, Long id_contrat) {
        this.nom = nom;

        this.contrat = contrat;
    }*/

    public Long getID(){
        return id_client;
    }

    public void setID(Long id_customer){
        this.id_client = id_customer;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Contract getContrat() {
        return contrat;
    }

    public void setContrat(Contract contrat) {
        this.contrat = contrat;
    }
}
