package by.komikow.services;

import by.komikow.dto.ProductResponse;
import by.komikow.repositories.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository = new ProductRepository();

    @Override
    public void createProduct(String productName, String productDescription, BigDecimal productPrice, int productQuantity, int productFkUnit) {
        productRepository.createProduct(productName, productDescription, productPrice, productQuantity, productFkUnit);
    }

    @Override
    public List<ProductResponse> readProducts() {
        return productRepository.readProducts();
    }

    @Override
    public void readProductById(int id) {
        productRepository.getProductById(id);
    }

    @Override
    public void updatePriceOfProduct(int id, BigDecimal newPrice) {
        productRepository.updatePriceOfProduct(id, newPrice);
    }

    public void updateQuantityOfProduct(int id, int newQuantity) {
        productRepository.updateQuantityOfProduct(id, newQuantity);
    }

    @Override
    public void deleteProductById(int id) {
        productRepository.deleteProductById(id);
    }
}
