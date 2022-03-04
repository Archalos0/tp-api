package com.api.product.api.product.util;

public class Calcul {

    public static float TVA = 20f;

    public static float CalculSellingPrice(float productPrice, float marge){

        float sellingPrice;

        sellingPrice = productPrice + CalculPercent(productPrice, marge) + CalculPercent(productPrice, Calcul.TVA);

        return Arrond2Decimal(sellingPrice);
    }

    public static float CalculPercent(float price, float percent){
        return price * percent / 100;
    }

    public static float Arrond2Decimal(float price){
        return Math.round(price*100f) / 100f;
    }
}
