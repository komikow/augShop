package by.komikow.dto;

import java.math.BigDecimal;
import java.time.LocalDate;


public class OrderResponse {
    private int orderId;

    private LocalDate orderDate;

    private String customerName;

    private String productName;

    private int quantity;

    private String unit;

    private BigDecimal orderPrice;

    private String statusType;

    public OrderResponse() {
    }

    public OrderResponse(int orderId, LocalDate orderDate, String customerName, String productName, int quantity, String unit, BigDecimal orderPrice, String statusType) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.unit = unit;
        this.orderPrice = orderPrice;
        this.statusType = statusType;
    }

    @Override
    public String toString() {
        return "OrderResponse: " +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", customerName='" + customerName + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                ", orderPrice=" + orderPrice +
                ", statusType='" + statusType;
    }
}
