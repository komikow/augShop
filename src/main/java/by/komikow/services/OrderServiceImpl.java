package by.komikow.services;

import by.komikow.dto.OrderResponse;
import by.komikow.repositories.OrderRepository;

import java.time.LocalDate;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository = new OrderRepository();

    //
    @Override
    public void createOrder(LocalDate orderDate, int fkCustomer, int fkProduct, int quantity, int fkUnit, int fkStatus) {
        orderRepository.createOrder(orderDate, fkCustomer, fkProduct, quantity, fkUnit, fkStatus);
    }

    @Override
    public List<OrderResponse> readOrders() {
        return orderRepository.readOrders();
    }

    @Override
    public void updateStatusOrderById(int id, int newStatusId) {
        orderRepository.updateStatusOrderById(id, newStatusId);
    }

    @Override
    public void deleteOrderById(int id) {
        orderRepository.deleteOrderById(id);
    }

    @Override
    public List<OrderResponse> findOrderByDate(LocalDate date) {
        return orderRepository.findOrderByDate(date);
    }

    @Override
    public List<OrderResponse> findOrderByStatus(int statusId) {
        return orderRepository.findOrderByStatus(statusId);
    }
}
