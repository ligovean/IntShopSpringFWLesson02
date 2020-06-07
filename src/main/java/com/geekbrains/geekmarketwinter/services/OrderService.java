package com.geekbrains.geekmarketwinter.services;

import com.geekbrains.geekmarketwinter.entites.Order;
import com.geekbrains.geekmarketwinter.entites.OrderItem;
import com.geekbrains.geekmarketwinter.entites.User;
import com.geekbrains.geekmarketwinter.repositories.OrderRepository;
import com.geekbrains.geekmarketwinter.utils.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private OrderStatusService orderStatusService;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setOrderStatusService(OrderStatusService orderStatusService) {
        this.orderStatusService = orderStatusService;
    }

    public List<Order> getAllOrders(){
        return (List<Order>) orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public Order makeOrder(ShoppingCart currentCart, User user) {
        Order order = new Order();
        List<OrderItem> orderItems = currentCart.getItems();

        order.setId(0L);
        order.setUser(user);
        order.setOrderStatus(orderStatusService.getStatusById(1L));
        order.setPrice(currentCart.getTotalCost());
        order.setOrderItems(orderItems);
        for (OrderItem orderItem : orderItems) {
            orderItem.setOrder(order);
        }
        return order;
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
