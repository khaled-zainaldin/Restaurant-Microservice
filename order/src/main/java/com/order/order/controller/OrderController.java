package com.order.order.controller;


import com.order.order.VO.ResponseTemplateVO;
import com.order.order.models.Order;
import com.order.order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @PostMapping("/add")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {

        Order orderAdd = orderService.create(order);

        return new ResponseEntity<>(orderAdd, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Order> getById(@PathVariable Long id) {
//        return ResponseEntity.ok(orderService.getById(id));
//    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Order> update(@PathVariable Long id,
                                        @RequestBody Order order) {
        return ResponseEntity.ok(orderService.update(id, order));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.ok("Order deleted");
    }

        @GetMapping("/{id}")
    public ResponseEntity<ResponseTemplateVO> getOrderWithMenuItemByOrderId(@PathVariable("id") Long OrderId){
    ResponseTemplateVO vo =this.orderService.getOrderWithMenuItemByOrderId( OrderId);
        return new ResponseEntity<>(vo,HttpStatus.OK);

        }

}