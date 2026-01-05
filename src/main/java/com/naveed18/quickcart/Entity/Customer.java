package com.naveed18.quickcart.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private int custId;

    @Column(name = "cust_name")
    private String custName;

    @Column(name = "cust_address")
    private String custAddress;

    @Column(name = "cust_mobile")
    private String custMobile;

    @ManyToOne
    @JoinColumn(name="percentage")
    private Coupon coupon;

    public Customer(String custName, String custAddress, String custMobile, Coupon coupon) {
        this.custName = custName;
        this.custAddress = custAddress;
        this.custMobile = custMobile;
        this.coupon = coupon;
    }
}
