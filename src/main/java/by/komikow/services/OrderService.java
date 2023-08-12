package by.komikow.services;

import by.komikow.dto.OrderResponse;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    public void createOrder(LocalDate orderDate, int fkCustomer, int fkProduct, int quantity, int fkUnit, int fkStatus);

    public List<OrderResponse> readOrders();

    public void updateStatusOrderById(int id, int newStatusId);

    public void deleteOrderById(int id);

    public List<OrderResponse> findOrderByDate(LocalDate date);

    public List<OrderResponse> findOrderByStatus(int statusId);
}
