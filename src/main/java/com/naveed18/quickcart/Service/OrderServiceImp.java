package com.naveed18.quickcart.Service;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naveed18.quickcart.Entity.Coupon;
import com.naveed18.quickcart.Entity.OrderTransaction;
import com.naveed18.quickcart.Entity.Product;
import com.naveed18.quickcart.Exception.InvalidCouponException;
import com.naveed18.quickcart.Exception.InvalidQuantityException;
import com.naveed18.quickcart.Exception.ProductNotFoundException;
import com.naveed18.quickcart.Helper.OrderRequest;
import com.naveed18.quickcart.Helper.OrderResponse;


@Transactional(rollbackFor = Exception.class) 
@Service
public class OrderServiceImp implements OrderService{
    /*
        FLOW :
        1. Validate product
        2. Validate quantity
        3. Validate coupon (optional)
        4. Calculate amount
        5. Generate IDs
        6. Create OrderTransaction
        7. Save OrderTransaction
        8. Create OrderResponse
        9. Return OrderResponse
 
    */

    private ProductService productService;

    private CouponService couponService;

    private OrderTransactionService orderTransactionService;

    public OrderServiceImp (ProductService productService, 
                            CouponService couponService,
                            OrderTransactionService orderTransactionService) {

        this.productService = productService;
        this.couponService = couponService;
        this.orderTransactionService = orderTransactionService;
    }

    @Override
    public OrderResponse placeOrder(int custId, OrderRequest orderRequest) 
            throws ProductNotFoundException, InvalidQuantityException, InvalidCouponException {

        int productId = orderRequest.getProductId(); 
        int quantity = orderRequest.getQuantity();
        String couponCode = orderRequest.getCouponCode();

//-----------------------------------------------START--EXCEPTION HANDLING-----------------------------------------------------------
        
        // Search & Validate The Product
        Product product = productService
                            .findById(productId)
                            .orElseThrow(() -> new ProductNotFoundException("Invalid product"));

        // Exception Handling --- Quantity
        if (product.getAvailable() < quantity || quantity <= 0) {
            throw new InvalidQuantityException("Invalid quantity");
        }

        // Exception Handling --- Coupon
        Coupon coupon = null;
        
        if (couponCode != null && !couponCode.isBlank()) {
            coupon = couponService
                            .findByCouponCode(orderRequest.getCouponCode())
                            .orElseThrow(() -> new InvalidCouponException("Invalid coupon"));
        }

//------------------------------------------------END--EXCEPTION HANDLING------------------------------------------------------------      


//--------------------------------------------START--GENERATING--ORDER--RESPONSE-----------------------------------------------------
       
        // Generate Transaction ID
        String transactionId = UUID.randomUUID().toString();

        // Generate Order ID
        int orderId = (int) (System.currentTimeMillis() % 100000);

        // Calculate Payable Amount
        int baseAmount = product.getPrice() * quantity;
        int finalAmount = baseAmount;

        if (coupon != null) {
            int discount = (baseAmount * coupon.getPercentage()) / 100;
            finalAmount -= discount;
        }

        // Creating Response Object
        OrderResponse orderResponse = new OrderResponse (
            transactionId, orderId, productId, quantity, 
            finalAmount, couponCode, "SUCCESS", "Order placed successfully"
        );

//--------------------------------------------END--GENERATING--ORDER--RESPONSE-----------------------------------------------------
   

        // Product Update
        product.setAvailable(product.getAvailable() - quantity);
    
        
//--------------------------------------------START--SAVE--ORDER--TRANSACTION-----------------------------------------------------

        OrderTransaction orderTxn = new OrderTransaction (
            orderResponse.getTransactionId(), orderId, custId, productId, 
            finalAmount, couponCode, "SUCCESS", LocalDate.now()
        );

        // Save Transaction
        orderTransactionService.saveTransaction(orderTxn);

//--------------------------------------------END--SAVE--ORDER--TRANSACTION-----------------------------------------------------
        
        return orderResponse;
    }
    
}
