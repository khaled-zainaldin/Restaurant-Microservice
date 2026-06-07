package com.payment.payment.controller;


import com.payment.payment.models.Payment;
import com.payment.payment.services.PaymentService;
import com.payment.payment.vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/add")
    public ResponseEntity<Payment> create(@RequestBody Payment payment) {

        Payment newPayment = Payment.builder()
                .amount(payment.getAmount())
                .method(payment.getMethod())
                .status("SUCCESS")
                .orderId(payment.getOrderId())
                .build();

        return ResponseEntity.ok(paymentService.create(newPayment));
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAll() {
        return ResponseEntity.ok(paymentService.getAll());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Payment> getById(@PathVariable Long id) {
//        return ResponseEntity.ok(paymentService.getById(id));
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        paymentService.delete(id);
        return ResponseEntity.ok("Payment deleted");
    }

    public ResponseEntity<ResponseTemplateVO> getOrderWithMenuItemByOrderId(@PathVariable("id") Long PaymentId){
        ResponseTemplateVO vo =this.paymentService.getPaymentWithOrderByPaymentId( PaymentId);
        return new ResponseEntity<>(vo, HttpStatus.OK);

    }
}