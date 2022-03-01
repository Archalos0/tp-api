package com.api.product.api.product.model;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class Product {

    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id_article;
    private String designation;
    private float prix;

    public Product() {}

    Product(String designation, float prix) {
        this.designation = designation;
        this.prix = prix;
    }

    public Long getID() {
        return id_article;
    }
    public void setID(Long id) { this.id_article = id; }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}
