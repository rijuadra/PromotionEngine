package com.ecommerce.bo;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
    //to maintain the list of all available products along with the price
    public static Map<String, Integer> productList = new HashMap<String, Integer>();

    public Map<String, Integer> getProductList() {
        return productList;
    }

    public void setProductList(Map<String, Integer> productList) {
        this.productList = productList;
    }
}
