package com.ecommerce.promotion;

import java.util.HashMap;

public interface IPromotion {
    public long calculatePriceWithPromotion(HashMap<String,Integer> checkoutProductList);
}
