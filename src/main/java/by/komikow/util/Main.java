package by.komikow.util;

import by.komikow.controllers.CustomerController;
import by.komikow.controllers.OrderController;
import by.komikow.controllers.ProductController;

public class Main {
    public static void main(String[] args) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        ProductController productController = new ProductController();
        CustomerController customerController = new CustomerController();
        OrderController orderController = new OrderController();
        orderController.deleteOrderById(3);
        /**
         * ниже приведены примеры вызова методов
         */
//        LocalDate date = LocalDate.of(2023, 8, 2);
//        List<OrderResponse> orderByDate = orderController.findOrderByDate(date);
//        List<OrderResponse> orderResponses = orderController.findOrderByStatus(2);
//        for (OrderResponse orderResponse: orderResponses) {
//            System.out.println(orderResponse);
//        }
//        orderController.createOrder(date, 1, 6, 1, 3, 2);
//        productController.updatePriceOfProduct(1, BigDecimal.valueOf(19.4));
//        List<ProductResponse> productResponses = productController.readProducts();
//        for (ProductResponse productResponse: productResponses) {
//            System.out.println(productResponse);
//        }
//        productController.updateQuantityOfProduct(1, 17);
//        customerController.createCustomer("ОДО \"БелОпт\"", "belopt@gmail.com");
//        productController.createProduct("Масло моторное", "Mobil Super 3000 X1 5W-40 синтетическое 4л.", BigDecimal.valueOf(163), 5, 3);
    }
}
