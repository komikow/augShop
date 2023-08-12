package by.komikow.repositories;

import by.komikow.dao.Order;
import by.komikow.dto.OrderResponse;
import by.komikow.mapper.OrderMapper;
import by.komikow.util.HibernateUtil;
import by.komikow.util.Utils;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    HibernateUtil hibernateUtil = new HibernateUtil();

    public void createOrder(LocalDate orderDate, int fkCustomer, int fkProduct, int quantity, int fkUnit, int fkStatus) {
        BigDecimal orderPriceProduct = Utils.getOrderPriceByFkId(fkProduct).multiply(BigDecimal.valueOf(quantity));

        String query = "insert into orders (order_date, fk_customer, fk_product, quantity, fk_unit, order_price, fk_status)" +
                "values ('" + java.sql.Date.valueOf(orderDate) + "'," + fkCustomer
                + "," + fkProduct + "," + quantity + "," + fkUnit + "," + orderPriceProduct + "," + fkStatus + ")";
        try {
            hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Заказ успешно создан");
    }

    public List<OrderResponse> readOrders() {
        List<OrderResponse> orders = new ArrayList<>();
        Order order;
        OrderMapper orderMapper;
        try {
            ResultSet resultSet = hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeQuery("select * from orders");
            while (resultSet.next()) {
                order = new Order(resultSet.getInt(1),
                        resultSet.getDate(2).toLocalDate(),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6),
                        resultSet.getInt(8));
                orderMapper = new OrderMapper();
                OrderResponse orderResponse = orderMapper.buildOrderResponse(order);
                orders.add(orderResponse);
            }
            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<OrderResponse> findOrderByDate(LocalDate date) {
        List<OrderResponse> orderList = new ArrayList<>();
        String query = "select * from orders where order_date = '" + java.sql.Date.valueOf(date) + "'";
        Order order;
        OrderMapper orderMapper;
        try {
            ResultSet resultSet = hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeQuery(query);
            while (resultSet.next()) {
                order = new Order(resultSet.getInt(1),
                        resultSet.getDate(2).toLocalDate(),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6),
                        resultSet.getInt(8));
                orderMapper = new OrderMapper();
                OrderResponse orderResponse = orderMapper.buildOrderResponse(order);
                orderList.add(orderResponse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public void updateStatusOrderById(int id, int newStatusId) {
        String query = "update orders set fk_status=" + id + " where order_id = " + newStatusId;
        try {
            hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Статус заказа изменен.");
    }

    public List<OrderResponse> findOrderByStatus(int status_id) {
        List<OrderResponse> orderList = new ArrayList<>();
        String query = "select * from orders where fk_status = " + status_id;
        Order order;
        OrderMapper orderMapper = new OrderMapper();
        try {
            ResultSet resultSet = hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeQuery(query);
            while (resultSet.next()) {
                order = new Order(resultSet.getInt(1),
                        resultSet.getDate(2).toLocalDate(),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6),
                        resultSet.getInt(8));
                OrderResponse orderResponse = orderMapper.buildOrderResponse(order);
                orderList.add(orderResponse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public void deleteOrderById(int id) {
        String query = "delete from orders where order_id=" + id;
        try {
            hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Заказ с id = " + id + " удалён.");
    }
}
