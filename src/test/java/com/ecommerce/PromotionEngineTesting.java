package com.ecommerce;

import com.ecommerce.service.CheckoutHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.ecommerce.bo.ProductCatalog.*;

public class PromotionEngineTesting {
    @Before
    public void setUp() {
        productList.put("A", 50);
        productList.put("B", 30);
        productList.put("C", 20);
        productList.put("D", 15);
    }

    @Test
    public void checkoutWithoutPrmotion() {
        CheckoutHandler checkoutHandler = new CheckoutHandler();
        checkoutHandler.addProductsToCart("A", 1);
        checkoutHandler.addProductsToCart("B", 1);
        checkoutHandler.addProductsToCart("C", 1);
        checkoutHandler.addProductsToCart("D", 1);
        Assert.assertEquals(115, checkoutHandler.calculateFinalPrice());
    }
}
