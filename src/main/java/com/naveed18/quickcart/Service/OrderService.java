package com.naveed18.quickcart.Service;

import com.naveed18.quickcart.Helper.OrderRequest;
import com.naveed18.quickcart.Helper.OrderResponse;

public interface OrderService {
    public OrderResponse placeOrder (int custId, OrderRequest orderRequest);
}
