package com.payment.payment.services;


import com.payment.payment.models.Payment;
import com.payment.payment.Repository.PaymentRepository;
import com.payment.payment.vo.Order;
import com.payment.payment.vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    public Payment getById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }


    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }

    public ResponseTemplateVO getPaymentWithOrderByPaymentId(Long paymentId) {
        Payment payment =this.getById(paymentId);
        Order order =this.restTemplate.getForObject("http://ORDER-SERVICE/api/orders/"+payment.getOrderId(),Order.class);
        ResponseTemplateVO vo =new ResponseTemplateVO();
        vo.setOrder(order);
        vo.setPayment(payment);
        return vo;
    }
}