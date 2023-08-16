package by.komikow.dao;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_price")
    private BigDecimal productPrice;

    @Column(name = "product_quantity")
    private int productQuantity;

    @Column(name = "product_fk_unit")
    private int productFkUnit;

    public Product() {
    }

    public Product(int productId, String productName, String productDescription,
                   BigDecimal productPrice, int productQuantity, int productFkUnit) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productFkUnit = productFkUnit;
    }
}
