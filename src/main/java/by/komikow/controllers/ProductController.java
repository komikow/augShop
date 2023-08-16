package by.komikow.controllers;

import by.komikow.dto.ProductResponse;
import by.komikow.services.ProductService;
import by.komikow.services.ProductServiceImpl;

import java.math.BigDecimal;
import java.util.List;

public class ProductController {
    private ProductService productService = new ProductServiceImpl();

    public List<ProductResponse> readProducts() {
        return productService.readProducts();
    }

    public void createProduct(String productName, String productDescription, BigDecimal productPrice, int productQuantity, int productFkUnit) {
        productService.createProduct(productName, productDescription, productPrice, productQuantity, productFkUnit);
    }

    public void getProductById(int id) {
        productService.readProductById(id);
    }

    public void updatePriceOfProduct(int id, BigDecimal newPrice) {
        productService.updatePriceOfProduct(id, newPrice);
    }

    public void updateQuantityOfProduct(int id, int newQuantity) {
        productService.updateQuantityOfProduct(id, newQuantity);
    }

    public void deleteProductById(int id) {
        productService.deleteProductById(id);
    }
}
