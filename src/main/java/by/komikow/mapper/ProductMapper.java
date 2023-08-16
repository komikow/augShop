package by.komikow.mapper;

import by.komikow.dao.Product;
import by.komikow.dao.Unit;
import by.komikow.dto.ProductResponse;
import by.komikow.util.Utils;

import java.math.BigDecimal;

public class ProductMapper {
    private Unit unit;

    public ProductResponse buildProductResponse(Product product) {
        int productId = product.getProductId();
        String productName = product.getProductName();
        String productDescription = product.getProductDescription();
        BigDecimal productPrice = product.getProductPrice();
        int productQuantity = product.getProductQuantity();
        String productUnit = Utils.getUnitNameByFkId(product.getProductFkUnit());
        return new ProductResponse(productId, productName, productDescription, productPrice, productQuantity, productUnit);
    }
}
