package com.naveed18.quickcart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.naveed18.quickcart.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
}
