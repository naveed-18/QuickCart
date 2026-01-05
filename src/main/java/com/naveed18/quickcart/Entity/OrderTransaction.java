package com.naveed18.quickcart.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderTransaction {
    @Id
    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "amount")
    private int amount;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "coupon")
    private String coupon;

    @Column(name = "status")
    private String status;
}
