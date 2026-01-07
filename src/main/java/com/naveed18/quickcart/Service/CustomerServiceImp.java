package com.naveed18.quickcart.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.naveed18.quickcart.Entity.Customer;
import com.naveed18.quickcart.Repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService{

    private CustomerRepository customerRepository;

    public CustomerServiceImp (CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> viewCustomers() {
        return customerRepository.findAll();
    }
    
}
