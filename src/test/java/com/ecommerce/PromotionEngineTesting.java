package com.ecommerce;

import com.ecommerce.promotion.impl.CandDComboOffer;
import com.ecommerce.promotion.impl.ThreeADiscountOffer;
import com.ecommerce.promotion.impl.TwoBDiscountOffer;
import com.ecommerce.service.CheckoutHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

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
    @Test
    public void checkoutWithThreeAPrmotionScinario1() {
        CheckoutHandler checkoutHandler = new CheckoutHandler();
        checkoutHandler.addProductsToCart("A", 6);
        HashMap<String, Integer> checkoutProductList = checkoutHandler.getCartDetails().getCheckoutProductList();
        long l = checkoutHandler.calculatePriceWithPromotion(new ThreeADiscountOffer(),checkoutProductList);
        Assert.assertEquals(260,l);
    }
    @Test
    public void checkoutWithThreeAPrmotionScinario2() {
        CheckoutHandler checkoutHandler = new CheckoutHandler();
        checkoutHandler.addProductsToCart("A", 5);
        HashMap<String, Integer> checkoutProductList = checkoutHandler.getCartDetails().getCheckoutProductList();
        long l = checkoutHandler.calculatePriceWithPromotion(new ThreeADiscountOffer(),checkoutProductList);
        Assert.assertEquals(230,l);
    }

    @Test
    public void checkoutWithTwoBPrmotionScinario1() {
        CheckoutHandler checkoutHandler = new CheckoutHandler();
        checkoutHandler.addProductsToCart("B", 4);
        HashMap<String, Integer> checkoutProductList = checkoutHandler.getCartDetails().getCheckoutProductList();
        long l = checkoutHandler.calculatePriceWithPromotion(new TwoBDiscountOffer(),checkoutProductList);
        Assert.assertEquals(90,l);
    }
    @Test
    public void checkoutWithTwoBPrmotionScinario2() {
        CheckoutHandler checkoutHandler = new CheckoutHandler();
        checkoutHandler.addProductsToCart("B", 5);
        HashMap<String, Integer> checkoutProductList = checkoutHandler.getCartDetails().getCheckoutProductList();
        long l = checkoutHandler.calculatePriceWithPromotion(new TwoBDiscountOffer(),checkoutProductList);
        Assert.assertEquals(120,l);
    }

    @Test
    public void checkoutWithCDPrmotionScianrio1() {
        CheckoutHandler checkoutHandler = new CheckoutHandler();
        checkoutHandler.addProductsToCart("C", 1);
        checkoutHandler.addProductsToCart("D", 1);
        HashMap<String, Integer> checkoutProductList = checkoutHandler.getCartDetails().getCheckoutProductList();
        long l = checkoutHandler.calculatePriceWithPromotion(new CandDComboOffer(),checkoutProductList);
        Assert.assertEquals(30,l);
    }
    @Test
    public void checkoutWithCDPrmotionScianrio2() {
        CheckoutHandler checkoutHandler = new CheckoutHandler();
        checkoutHandler.addProductsToCart("C", 1);
        checkoutHandler.addProductsToCart("D", 2);
        HashMap<String, Integer> checkoutProductList = checkoutHandler.getCartDetails().getCheckoutProductList();
        long l = checkoutHandler.calculatePriceWithPromotion(new CandDComboOffer(),checkoutProductList);
        Assert.assertEquals(45,l);
    }
    @Test
    public void checkoutWithCDPrmotionScianrio3() {
        CheckoutHandler checkoutHandler = new CheckoutHandler();
        checkoutHandler.addProductsToCart("C", 2);
        checkoutHandler.addProductsToCart("D", 1);
        HashMap<String, Integer> checkoutProductList = checkoutHandler.getCartDetails().getCheckoutProductList();
        long l = checkoutHandler.calculatePriceWithPromotion(new CandDComboOffer(),checkoutProductList);
        Assert.assertEquals(50,l);
    }

    @Test
    public void checkoutWithAllPrmotionScinario1() {
        CheckoutHandler checkoutHandler = new CheckoutHandler();
        checkoutHandler.addProductsToCart("A", 5);
        checkoutHandler.addProductsToCart("B", 5);
        checkoutHandler.addProductsToCart("C", 1);
        HashMap<String, Integer> checkoutProductList = checkoutHandler.getCartDetails().getCheckoutProductList();
        long price =0;
        price=price+ checkoutHandler.calculatePriceWithPromotion(new ThreeADiscountOffer(),checkoutProductList);
        price=price+ checkoutHandler.calculatePriceWithPromotion(new TwoBDiscountOffer(),checkoutProductList);
        price=price+ checkoutHandler.calculatePriceWithPromotion(new CandDComboOffer(),checkoutProductList);
        Assert.assertEquals(370,price);
    }

    @Test
    public void checkoutAllPrmotionScinario2() {
        CheckoutHandler checkoutHandler = new CheckoutHandler();
        checkoutHandler.addProductsToCart("A", 3);
        checkoutHandler.addProductsToCart("B", 5);
        checkoutHandler.addProductsToCart("C", 1);
        checkoutHandler.addProductsToCart("D", 1);
        HashMap<String, Integer> checkoutProductList = checkoutHandler.getCartDetails().getCheckoutProductList();
        long price =0;
        price=price+ checkoutHandler.calculatePriceWithPromotion(new ThreeADiscountOffer(),checkoutProductList);
        price=price+ checkoutHandler.calculatePriceWithPromotion(new TwoBDiscountOffer(),checkoutProductList);
        price=price+ checkoutHandler.calculatePriceWithPromotion(new CandDComboOffer(),checkoutProductList);
        Assert.assertEquals(280,price);
    }
}
