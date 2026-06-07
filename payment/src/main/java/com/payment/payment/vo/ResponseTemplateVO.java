package com.payment.payment.vo;

import com.payment.payment.models.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private Order order;
    private Payment payment;
}
