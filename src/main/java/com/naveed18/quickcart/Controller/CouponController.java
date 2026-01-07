package com.naveed18.quickcart.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.naveed18.quickcart.Entity.Coupon;
import com.naveed18.quickcart.Service.CouponService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class CouponController {
    /*
        TODO :
        -> Fetch All Coupons
    */

    private CouponService couponService;

    public CouponController (CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping("/view-coupons")
    public ResponseEntity<List<Coupon>> getAllCoupons() {
        return ResponseEntity.ok(couponService.getAllCoupons());
    }
    
}
