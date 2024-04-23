package dw.wholesale_company.controller;

import dw.wholesale_company.model.Order;
import dw.wholesale_company.service.OrderService; // OrderService import 추가
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity<>(orderService.getAllOrders(),
                HttpStatus.OK);
    }
}
