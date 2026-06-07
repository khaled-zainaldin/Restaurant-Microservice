package com.payment.payment.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {


    private Long id;
    private Long menuItemId;

    private String customerName;

    private Double totalPrice;

    private LocalDateTime orderDate;

    private String status;
}
