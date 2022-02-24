package com.api.product.api.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article {

    private @Id @GeneratedValue Long id_article;
    public String designation;
    public float prix;

    Article() {}

    Article(String designation, float prix) {
        this.designation = designation;
        this.prix = prix;
    }

    public Long GetID() {
        return id_article;
    }
}
