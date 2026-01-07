package com.naveed18.quickcart.Service;

import java.util.List;

import com.naveed18.quickcart.Entity.OrderTransaction;

public interface OrderTransactionService {
    
    public void saveTransaction (OrderTransaction orderTransaction);

    public List<OrderTransaction> getAllOrders();

    public List<OrderTransaction> getAllOrderByCustId(int custId);
}
