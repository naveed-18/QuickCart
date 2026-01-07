package com.naveed18.quickcart.Exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException (String message) {
        super(message);
    }
    
}
