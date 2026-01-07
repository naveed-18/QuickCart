package com.naveed18.quickcart.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class QuickCartController {
    @GetMapping("/")
    public String homePage() {
        return "Welcome To QuickCart -- E-Commerce Backend System";
    }
    
}
