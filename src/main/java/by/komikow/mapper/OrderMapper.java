package by.komikow.mapper;

import by.komikow.dao.Customer;
import by.komikow.dao.Order;
import by.komikow.dto.OrderResponse;
import by.komikow.util.Utils;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderMapper {
    private Customer customer;

    public OrderResponse buildOrderResponse(Order order) {
        int orderId = order.getOrderId();
        LocalDate orderDate = order.getOrderDate();
        String customerName = Utils.getCustomerNameByFkId(order.getFkCustomer());
        String productName = Utils.getProductNameByFkId(order.getFkProduct());
        int quantity = order.getQuantity();
        String unit = Utils.getUnitNameByFkId(order.getFkUnit());
        BigDecimal orderPrice = Utils.getOrderPriceByFkId(order.getFkProduct()).multiply(BigDecimal.valueOf(quantity));
        String statusType = Utils.getStatusNameByFkId(order.getFkStatus());
        return new OrderResponse(orderId, orderDate, customerName, productName, quantity, unit, orderPrice, statusType);
    }
}
