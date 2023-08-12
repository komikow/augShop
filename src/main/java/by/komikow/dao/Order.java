package by.komikow.dao;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

//@Builder
@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "fk_customer")
    private int fkCustomer;

    @Column(name = "fk_product")
    private int fkProduct;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "fk_unit")
    private int fkUnit;

    @Column(name = "order_price")
    private BigDecimal orderPrice;

    @Column(name = "fk_status")
    private int fkStatus;

    public Order() {
    }

    public Order(int orderId, LocalDate orderDate, int fkCustomer, int fkProduct, int quantity, int fkUnit, int fkStatus) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.fkCustomer = fkCustomer;
        this.fkProduct = fkProduct;
        this.quantity = quantity;
        this.fkUnit = fkUnit;
        this.fkStatus = fkStatus;
    }
}
