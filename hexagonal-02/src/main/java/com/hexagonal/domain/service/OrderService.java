package com.hexagonal.domain.service;

import com.hexagonal.domain.model.Order;
import com.hexagonal.domain.model.OrderItem;
import com.hexagonal.domain.repository.OrderRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class OrderService {

    @Inject
    OrderRepository orderRepository;

    @Transactional
    public Order createOrder(Order order) {
        orderRepository.persist(order);
        return order;
    }

    @Transactional
    public void addItemToOrder(Long orderId, OrderItem item) {
        Order order = orderRepository.findById(orderId);
        if (order != null) {
            order.getItems().add(item);
            orderRepository.persist(order);
        }
    }

    @Transactional
    public void updateOrderStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId);
        if (order != null) {
            order.setStatus(status);
            orderRepository.persist(order);
        }
    }

    public List<Order> getAllOrders() {
        return orderRepository.listAll();
    }

    public Order findOrderById (Long id) {
        return orderRepository.findById(id);
    }

}
