package com.ecommerce.service;

import com.ecommerce.bo.Cart;
import com.ecommerce.promotion.IPromotion;

import java.util.HashMap;

import static com.ecommerce.bo.ProductCatalog.*;

public class CheckoutHandler {
    private Cart cart;

    public CheckoutHandler() {
        cart = new Cart();
    }

    public boolean addProductsToCart(String sku_id, int quantity) {
        cart.getCheckoutProductList().put(sku_id, quantity);
        return true;
    }

    public Cart getCartDetails() {
        return this.cart;
    }

    /**
     * to calculate prices of all products
     * that are available in the cart without
     * applying any promotion
     **/
    public int calculateFinalPrice() {
        int sum = 0;
        HashMap<String, Integer> checkoutProductList = cart.getCheckoutProductList();
        for (String sku_id : checkoutProductList.keySet()) {
            int price = productList.get(sku_id);
            int quantity = checkoutProductList.get(sku_id);
            sum = sum + price * quantity;
        }
        return sum;
    }

    /**
     * to calculate prices of all products
     * that are available in the cart with
     * applying required promotion
     **/
    public long calculatePriceWithPromotion(IPromotion promotion, HashMap<String, Integer> checkoutProductList) {
        return promotion.calculatePriceWithPromotion(checkoutProductList);
    }
}
