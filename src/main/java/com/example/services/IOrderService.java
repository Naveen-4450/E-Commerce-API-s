package com.example.services;

import com.example.enums.OrderStatus;
import com.example.models.dbModels.Orders;
import com.example.models.dtoModels.FetchOrderDetailsDto;
import com.example.models.dtoModels.OrdersDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IOrderService
{
    ResponseEntity<String> createOrder(OrdersDto oDto);

    ResponseEntity<FetchOrderDetailsDto> getOrderById(int orderId);

    ResponseEntity<List<FetchOrderDetailsDto>> getOrderByCustomerId(int custId);

    ResponseEntity<String> updateOrderStatus(int orderId, OrderStatus status);
}











   /*ResponseEntity<String> orderStatusShipped(int orderId);
    ResponseEntity<String> orderStatusDelivered(int orderId);
    ResponseEntity<String> orderStatusCancelled(int orderId);*/