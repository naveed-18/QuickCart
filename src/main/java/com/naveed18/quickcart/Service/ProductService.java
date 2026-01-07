package com.naveed18.quickcart.Service;

import java.util.Optional;
import com.naveed18.quickcart.Entity.Product;

public interface ProductService {
    
    public Optional<Product> findById(int productId);

    public void saveProduct (Product product);
}
