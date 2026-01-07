package com.naveed18.quickcart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naveed18.quickcart.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
