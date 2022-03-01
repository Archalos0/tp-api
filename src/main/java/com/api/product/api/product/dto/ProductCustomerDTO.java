package com.api.product.api.product.dto;

import com.api.product.api.product.model.Product;
import lombok.Data;

@Data
public class ProductCustomerDTO {

    private Long id_article;
    private String designation;
    private float prix;
    private float prix_vente;

    public static ProductCustomerDTO from(Product product, float marge){
        ProductCustomerDTO productContractDTO = new ProductCustomerDTO();

        productContractDTO.setId_article(product.getID());
        productContractDTO.setDesignation(product.getDesignation());
        productContractDTO.setPrix(product.getPrix());

        productContractDTO.setPrix_vente(product.getPrix() + (marge / 100f * product.getPrix()) + (20f/100f * product.getPrix()));

        return productContractDTO;
    }
}
