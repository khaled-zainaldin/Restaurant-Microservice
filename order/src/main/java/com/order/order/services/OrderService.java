package com.order.order.services;


import com.order.order.VO.MenuItem;
import com.order.order.VO.ResponseTemplateVO;
import com.order.order.models.Order;
import com.order.order.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;
    public Order create(Order order) {
        Order newOrder = Order.builder()
                .customerName(order.getCustomerName())
                .menuItemId(order.getMenuItemId())
                .totalPrice(order.getTotalPrice())
                .orderDate(LocalDateTime.now())
                .status("NEW")
                .build();

        return orderRepository.save(newOrder);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order update(Long id, Order newOrder) {
        Order existing = getById(id);

        Order updated = existing.toBuilder()
                .customerName(newOrder.getCustomerName())
                .menuItemId(newOrder.getMenuItemId())
                .totalPrice(newOrder.getTotalPrice())
                .status(newOrder.getStatus())
                .build();

        return orderRepository.save(updated);
    }


    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    public ResponseTemplateVO getOrderWithMenuItemByOrderId(Long orderId) {
        Order order =this.getById(orderId);
        MenuItem menuItem =this.restTemplate.getForObject("http://MENUITEM-SERVICE/api/menu/"+order.getMenuItemId(),MenuItem.class);
    ResponseTemplateVO vo =new ResponseTemplateVO();
    vo.setOrder(order);
    vo.setMenuitem(menuItem);
    return vo;
    }
}