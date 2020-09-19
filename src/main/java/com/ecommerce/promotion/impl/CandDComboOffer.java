package com.ecommerce.promotion.impl;

import com.ecommerce.promotion.IPromotion;
import static com.ecommerce.bo.ProductCatalog.*;
import java.util.HashMap;

public class CandDComboOffer implements IPromotion {
    private static final int PRICE_OF_C_AND_D=30;
    @Override
    public long calculatePriceWithPromotion(HashMap<String, Integer> checkoutProductList) {
        int quantityOfC = checkoutProductList.get("C")==null?0:checkoutProductList.get("C");
        int quantityOfD = checkoutProductList.get("D")==null?0:checkoutProductList.get("D");
        int price=0;
        if(quantityOfC>quantityOfD)
            price=quantityOfD*PRICE_OF_C_AND_D+(quantityOfC-quantityOfD)* productList.get("C");
        else
            price=quantityOfC*PRICE_OF_C_AND_D+(quantityOfD-quantityOfC)* productList.get("D");
        return price;
    }
}
