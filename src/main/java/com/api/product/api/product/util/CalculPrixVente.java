package com.api.product.api.product.util;

public class CalculPrixVente {

    public static float TVA = 20f;

    public static float CalculSellingPrice(float productPrice, float marge){

        float sellingPrice;

        sellingPrice = productPrice + (productPrice * marge / 100) + (productPrice * CalculPrixVente.TVA / 100);

        return sellingPrice;
    }
}
