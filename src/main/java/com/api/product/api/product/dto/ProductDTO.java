package com.api.product.api.product.dto;

import com.api.product.api.product.model.Contract;
import com.api.product.api.product.model.Product;
import lombok.Data;

import java.util.stream.Collectors;

@Data
public class ProductDTO {

    private Long id_article;
    private String designation;
    private float prix;

    public static ProductDTO from(Product product){
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId_article(product.getID());
        productDTO.setDesignation(product.getDesignation());
        productDTO.setPrix(product.getPrix());

        return productDTO;
    }

}
