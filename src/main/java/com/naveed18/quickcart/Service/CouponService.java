package com.naveed18.quickcart.Service;

import java.util.List;
import java.util.Optional;

import com.naveed18.quickcart.Entity.Coupon;

public interface CouponService {

    public Optional<Coupon> findByCouponCode (String couponCode);

    public List<Coupon> getAllCoupons ();
    
}
