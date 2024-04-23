package dw.wholesale_company.service;

import dw.wholesale_company.model.Order;
import dw.wholesale_company.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    OrderRepository orderRepository;

    @Autowired
    public  OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

}
