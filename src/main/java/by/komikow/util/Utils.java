package by.komikow.util;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utils {

    public static String getCustomerNameByFkId(int customerId) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        String customerName = null;
        //select customer_name from customers where customer_id = 2
        String query = "select customer_name from customers where customer_id = " + customerId;
        try {
            ResultSet resultSet = hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeQuery(query);
            while (resultSet.next()) {
                customerName = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerName;
    }

    public static String getProductNameByFkId(int productId) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        String productName = null;
        //select product_name from products where customer_id = 2
        String query = "select product_name from products where product_id = " + productId;
        try {
            ResultSet resultSet = hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeQuery(query);
            while (resultSet.next()) {
                productName = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productName;
    }

    public static BigDecimal getOrderPriceByFkId(int productId) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        BigDecimal productPrice = null;
        String query = "select product_price from products where product_id = " + productId;
        try {
            ResultSet resultSet = hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeQuery(query);
            while (resultSet.next()) {
                productPrice = resultSet.getBigDecimal(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productPrice;
    }

    public static String getStatusNameByFkId(int statusId) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        String statusName = null;
        String query = "select status_type from status where status_id = " + statusId;
        try {
            ResultSet resultSet = hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeQuery(query);
            while (resultSet.next()) {
                statusName = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statusName;
    }

    public static String getUnitNameByFkId(int unitId) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        String unitName = null;
        String query = "select unit_name from units where unit_id = " + unitId;
        try {
            ResultSet resultSet = hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeQuery(query);
            while (resultSet.next()) {
                unitName = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return unitName;
    }


    public static String getProductNameById(int productId) {
        return null;
    }

    public static String getStatusTypeById(int statusId) {
        return null;
    }

}
