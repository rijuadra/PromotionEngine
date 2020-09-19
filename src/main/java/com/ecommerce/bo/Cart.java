package com.ecommerce.bo;

import java.util.HashMap;

public class Cart {

    //to maintain the list of products that has been added to the cart along with the quantity
    private HashMap<String, Integer> checkoutProductList = new HashMap<>();

    public HashMap<String, Integer> getCheckoutProductList() {
        return checkoutProductList;
    }

    public void setCheckoutProductList(HashMap<String, Integer> checkoutProductList) {
        this.checkoutProductList = checkoutProductList;
    }
}
