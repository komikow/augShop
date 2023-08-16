package by.komikow.controllers;

import by.komikow.dto.OrderResponse;
import by.komikow.services.OrderService;
import by.komikow.services.OrderServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class OrderController {
    private OrderService orderService = new OrderServiceImpl();

    public void createOrder(LocalDate orderDate, int fkCustomer, int fkProduct, int quantity, int fkUnit, int fkStatus) {
        orderService.createOrder(orderDate, fkCustomer, fkProduct, quantity, fkUnit, fkStatus);
    }

    public List<OrderResponse> readOrders() {
        return orderService.readOrders();
    }

    public void updateStatusOrderById(int id, int newStatusId) {
        orderService.updateStatusOrderById(id, newStatusId);
    }

    public List<OrderResponse> findOrderByDate(LocalDate date) {
        return orderService.findOrderByDate(date);
    }

    public List<OrderResponse> findOrderByStatus(int statusId) {
        return orderService.findOrderByStatus(statusId);
    }

    public void deleteOrderById(int id) {
        orderService.deleteOrderById(id);
    }
}
