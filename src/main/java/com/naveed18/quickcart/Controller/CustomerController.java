package com.naveed18.quickcart.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.naveed18.quickcart.Entity.Customer;
import com.naveed18.quickcart.Service.CustomerService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class CustomerController {
    /*
        TODO :
        -> Fetch All Customers
    */

    private CustomerService customerService;

    public CustomerController (CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @GetMapping("/view-customers")
    public ResponseEntity<List<Customer>> viewCustomers() {
        return ResponseEntity.ok(customerService.viewCustomers());
    }
    
}
