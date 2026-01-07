package com.naveed18.quickcart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naveed18.quickcart.Entity.OrderTransaction;

public interface OrderTransactionRepository extends JpaRepository<OrderTransaction, String> {
    public List<OrderTransaction> findByCustId(int custId);

}
