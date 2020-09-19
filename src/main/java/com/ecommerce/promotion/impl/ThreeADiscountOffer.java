package com.ecommerce.promotion.impl;

import static com.ecommerce.bo.ProductCatalog.*;
import com.ecommerce.promotion.IPromotion;

import java.util.HashMap;

public class ThreeADiscountOffer implements IPromotion {
    @Override
    public long calculatePriceWithPromotion(HashMap<String, Integer> checkoutProductList) {
        int quantityOfA = checkoutProductList.get("A")==null?0:checkoutProductList.get("A");
        int price = quantityOfA / 3 * 130 + quantityOfA % 3 * productList.get("A");
        return price;
    }
}
