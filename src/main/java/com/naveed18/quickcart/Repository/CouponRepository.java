package com.naveed18.quickcart.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naveed18.quickcart.Entity.Coupon;


public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    public Optional<Coupon> findByCouponCode(String couponCode);
}
