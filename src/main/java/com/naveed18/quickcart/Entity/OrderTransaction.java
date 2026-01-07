package com.naveed18.quickcart.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OrderTransaction {
    @Id
    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "cust_id")
    private int custId;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "amount")
    private int amount;

    @Column(name = "coupon_code")
    private String couponCode;

    @Column(name = "status")
    private String status;

    @Column(name = "date")
    private LocalDate date;

    public OrderTransaction(String transactionId, int orderId, int custId, int productId, 
            int amount, String couponCode, String status, LocalDate date) {
        this.transactionId = transactionId;
        this.orderId = orderId;
        this.custId = custId;
        this.productId = productId;
        this.amount = amount;
        this.couponCode = couponCode;
        this.status = status;
        this.date = date;
    }

    

    
}
