package com.naveed18.quickcart.Exception;

public class InvalidCouponException extends RuntimeException {
    
    public InvalidCouponException (String message) {
        super(message);
    }
}
