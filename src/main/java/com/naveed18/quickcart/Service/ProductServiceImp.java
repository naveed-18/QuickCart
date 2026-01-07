package com.naveed18.quickcart.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.naveed18.quickcart.Entity.Product;
import com.naveed18.quickcart.Repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService{

    private ProductRepository productRepository;

    ProductServiceImp (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> findById(int productId) {
        return productRepository.findById(productId);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
    
}
