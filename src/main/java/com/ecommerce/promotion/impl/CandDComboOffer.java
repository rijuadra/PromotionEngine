package com.ecommerce.promotion.impl;

import com.ecommerce.promotion.IPromotion;
import static com.ecommerce.bo.ProductCatalog.*;
import java.util.HashMap;

public class CandDComboOffer implements IPromotion {
    @Override
    public long calculatePriceWithPromotion(HashMap<String, Integer> checkoutProductList) {
        int quantityOfC = checkoutProductList.get("C")==null?0:checkoutProductList.get("C");
        int quantityOfD = checkoutProductList.get("D")==null?0:checkoutProductList.get("D");
        int price=0;
        if(quantityOfC>quantityOfD)
            price=quantityOfD*30+(quantityOfC-quantityOfD)* productList.get("C");
        else
            price=quantityOfC*30+(quantityOfD-quantityOfC)* productList.get("D");
        return price;
    }
}
