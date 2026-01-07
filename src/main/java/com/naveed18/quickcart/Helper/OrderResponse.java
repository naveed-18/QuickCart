package com.naveed18.quickcart.Helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderResponse {
    
    private String transactionId;

    private int orderId;

    private int productId;

    private int quantity;

    private int amount;

    private String couponCode;

    private String status;

    private String message;
}
