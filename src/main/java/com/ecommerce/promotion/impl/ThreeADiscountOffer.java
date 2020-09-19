package com.ecommerce.promotion.impl;

import static com.ecommerce.bo.ProductCatalog.*;

import com.ecommerce.promotion.IPromotion;

import java.util.HashMap;

public class ThreeADiscountOffer implements IPromotion {
    private static final int PRICE_OF_3A = 130;
    /**
     * This method will calculate price of A
     **/
    @Override
    public long calculatePriceWithPromotion(HashMap<String, Integer> checkoutProductList) {
        int quantityOfA = checkoutProductList.get("A") == null ? 0 : checkoutProductList.get("A");
        int price = quantityOfA / 3 * PRICE_OF_3A + quantityOfA % 3 * productList.get("A");
        return price;
    }
}
