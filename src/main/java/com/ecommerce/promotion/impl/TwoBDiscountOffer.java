package com.ecommerce.promotion.impl;

import com.ecommerce.promotion.IPromotion;
import static com.ecommerce.bo.ProductCatalog.*;
import java.util.HashMap;

public class TwoBDiscountOffer implements IPromotion {
    private static final int PRICE_OF_2B=45;
    @Override
    public long calculatePriceWithPromotion(HashMap<String, Integer> checkoutProductList) {
        int quantityOfB = checkoutProductList.get("B")==null?0:checkoutProductList.get("B");
        int price = quantityOfB / 2 * PRICE_OF_2B + quantityOfB % 2 * productList.get("B");
        return price;
    }
}
