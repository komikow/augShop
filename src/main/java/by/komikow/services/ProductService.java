package by.komikow.services;

import by.komikow.dto.ProductResponse;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    public void createProduct(String productName, String productDescription, BigDecimal productPrice, int productQuantity, int productFkUnit);

    public List<ProductResponse> readProducts();

    public void readProductById(int id);

    public void updateQuantityOfProduct(int id, int newQuantity);

    public void updatePriceOfProduct(int id, BigDecimal newPrice);

    public void deleteProductById(int id);
}
