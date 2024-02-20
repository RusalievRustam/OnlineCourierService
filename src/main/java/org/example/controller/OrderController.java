package org.example.controller;

import jakarta.validation.Valid;
import org.aspectj.weaver.ast.Or;
import org.example.dto.OrderDTO;
import org.example.entity.Order;
import org.example.repositories.OrderRepository;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<OrderDTO> listAll() {
        return orderService.getAllOrders();
    }

    @PostMapping("/order")
    public OrderDTO createOrder(@Valid @RequestBody OrderDTO orderDTO) {
        orderService.saveOrder(orderDTO);
        return orderDTO;
    }

    @DeleteMapping("/order")
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @PutMapping("/order/orderId")
    public OrderDTO updateOrdersInfo(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        return orderService.updateOrderInfo(orderDTO, id);
    }
}
