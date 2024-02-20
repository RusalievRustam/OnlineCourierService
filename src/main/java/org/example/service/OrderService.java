package org.example.service;

import org.example.dto.OrderDTO;
import org.example.entity.Order;
import org.example.repositories.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Order convertToOrder(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, Order.class);
    }

    public OrderDTO convertToOrderDTO(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }

    public OrderDTO updateOrderInfo(OrderDTO orderDTO, Long id) {
        Order order = orderRepository.getReferenceById(id);
        order.setItem(orderDTO.getItem());
        order.setStatus(orderDTO.getStatus());
        order.setOrderDate(orderDTO.getOrderDate());
        order.setDeliverDate(orderDTO.getDeliverDate());
        orderRepository.save(order);
        return convertToOrderDTO(order);
    }

    public List<OrderDTO> getAllOrders() {
        List<Order> listOrder = orderRepository.findAll();
        List<OrderDTO> ordersDTO = new ArrayList<>();
        listOrder.forEach(c -> ordersDTO.add(convertToOrderDTO(c)));
        return ordersDTO;
    }

    public void saveOrder(OrderDTO orderDTO) {
        Order order = convertToOrder(orderDTO);
        orderRepository.save(order);
    }
}
