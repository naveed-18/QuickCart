package com.naveed18.quickcart.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.naveed18.quickcart.Entity.OrderTransaction;
import com.naveed18.quickcart.Repository.OrderTransactionRepository;

@Service
public class OrderTransactionServiceImp implements OrderTransactionService{

    private OrderTransactionRepository orderTransactionRepository;

    public OrderTransactionServiceImp (OrderTransactionRepository orderTransactionRepository) {
        this.orderTransactionRepository = orderTransactionRepository;
    }

    @Override
    public void saveTransaction(OrderTransaction orderTransaction) {
        orderTransactionRepository.save(orderTransaction);
    }

    @Override
    public List<OrderTransaction> getAllOrders() {
        return orderTransactionRepository.findAll();
    }

    @Override
    public List<OrderTransaction> getAllOrderByCustId(int custId) {
        return orderTransactionRepository.findByCustId(custId);
    }
}
