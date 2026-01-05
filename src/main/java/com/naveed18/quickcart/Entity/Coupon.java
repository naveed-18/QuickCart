package com.naveed18.quickcart.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Coupon {
    @Id
    @Column(name = "percentage")
    private int percentage;

    @Column(name = "discount")
    private String discount;
}
