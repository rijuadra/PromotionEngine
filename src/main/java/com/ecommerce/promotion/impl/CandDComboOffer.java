package com.ecommerce.promotion.impl;

import com.ecommerce.promotion.IPromotion;

import java.util.HashMap;

public class CandDComboOffer implements IPromotion {
    @Override
    public long calculatePriceWithPromotion(HashMap<String, Integer> checkoutProductList) {
        return 0;
    }
}
