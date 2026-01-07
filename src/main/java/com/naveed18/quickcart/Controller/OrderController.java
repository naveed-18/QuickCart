package com.naveed18.quickcart.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naveed18.quickcart.Entity.OrderTransaction;
import com.naveed18.quickcart.Helper.OrderRequest;
import com.naveed18.quickcart.Helper.OrderResponse;
import com.naveed18.quickcart.Service.OrderService;
import com.naveed18.quickcart.Service.OrderTransactionService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/customer")
public class OrderController {
    
    /*
        TODO :
        -> Place an Order
        -> Fetch All Orders
        -> Fetch Order by OrderID
    */

    private OrderService orderService;

    private OrderTransactionService orderTransactionService;

    public OrderController (OrderService orderService, OrderTransactionService orderTransactionService) {
        this.orderService = orderService;
        this.orderTransactionService = orderTransactionService;
    }

    @PostMapping("/{custId}/order")
    public OrderResponse placeOrder(
        @PathVariable("custId") int custId,
        @RequestBody OrderRequest orderRequest) {

        return orderService.placeOrder(custId, orderRequest);
    }  
    
    @GetMapping("/orders")
    public ResponseEntity<List<OrderTransaction>> getAllOrders() {
        return ResponseEntity.ok(orderTransactionService.getAllOrders());
    }
    
    @GetMapping("/orders/{custId}")
    public ResponseEntity<List<OrderTransaction>> getAllOrderById(@PathVariable("custId") int custId) {
        return ResponseEntity.ok(orderTransactionService.getAllOrderByCustId(custId));
    }
    
}
