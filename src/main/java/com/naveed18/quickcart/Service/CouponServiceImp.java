package com.naveed18.quickcart.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.naveed18.quickcart.Entity.Coupon;
import com.naveed18.quickcart.Repository.CouponRepository;

@Service
public class CouponServiceImp implements CouponService{

    private CouponRepository couponRepository;

    CouponServiceImp (CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public Optional<Coupon> findByCouponCode(String couponCode) {
        return couponRepository.findByCouponCode(couponCode);
    }

    @Override
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }
    
}
