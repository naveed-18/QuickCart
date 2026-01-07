package com.naveed18.quickcart.Config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.naveed18.quickcart.Entity.Coupon;
import com.naveed18.quickcart.Entity.Customer;
import com.naveed18.quickcart.Entity.Product;
import com.naveed18.quickcart.Repository.CouponRepository;
import com.naveed18.quickcart.Repository.CustomerRepository;
import com.naveed18.quickcart.Repository.ProductRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CouponRepository couponRepository;
    private final CustomerRepository customerRepository;


    public DataInitializer(
            ProductRepository productRepository,
            CouponRepository couponRepository,
            CustomerRepository customerRepository) {
                
        this.productRepository = productRepository;
        this.couponRepository = couponRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) {
        loadProducts();
        loadCoupons();
        loadCustomers();
    }

    private void loadProducts() {
        if (productRepository.count() == 0) {
            productRepository.saveAll(List.of(
                new Product(1, "Laptop", 10, 50000),
                new Product(2, "Phone", 15, 20000),
                new Product(3, "Headphones", 20, 3000),
                new Product(4, "Keyboard", 25, 1500),
                new Product(5, "Mouse", 30, 800),
                new Product(6, "Monitor", 8, 12000),
                new Product(7, "Printer", 5, 9000),
                new Product(8, "Webcam", 18, 2500),
                new Product(9, "Speaker", 12, 4000),
                new Product(10, "PowerBank", 22, 1800)
            ));
        }
    }

    private void loadCoupons() {
        if (couponRepository.count() == 0) {
            couponRepository.saveAll(List.of(
                new Coupon(20, "OFF20"),
                new Coupon(50, "OFF50")
            ));
        }
    }

    private void loadCustomers() {
        if (customerRepository.count() == 0) {
            customerRepository.saveAll(List.of(
                new Customer(1, "Naveed", "Hyderabad", "9999999991"),
                new Customer(2, "Wasifa", "Delhi", "9999999992"),
                new Customer(3, "pavan", "Mumbai", "9999999993"),
                new Customer(4, "Abhi", "Bangalore", "9999999994"),
                new Customer(5, "Bunny", "Chintal", "9999999995"),
                new Customer(6, "Venkat", "KPHB", "9999999996"),
                new Customer(7, "Mokshit", "Hyderabad", "9999999997"),
                new Customer(8, "Ram", "Chintal", "9999999998"),
                new Customer(9, "Eashwar", "Medak", "9999999999")
            ));
        }
    }
}

