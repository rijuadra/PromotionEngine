package com.ecommerce.promotion.impl;

import com.ecommerce.promotion.IPromotion;
import static com.ecommerce.bo.ProductCatalog.*;
import java.util.HashMap;

public class TwoBDiscountOffer implements IPromotion {
    @Override
    public long calculatePriceWithPromotion(HashMap<String, Integer> checkoutProductList) {
        int quantityOfB = checkoutProductList.get("B")==null?0:checkoutProductList.get("B");
        int price = quantityOfB / 2 * 45 + quantityOfB % 2 * productList.get("B");
        return price;
    }
}
