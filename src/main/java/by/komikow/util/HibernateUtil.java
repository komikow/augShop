package by.komikow.util;

import by.komikow.dao.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class HibernateUtil {
    private Connection connection;
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/webapp?serverTimezone=Europe/Minsk&useSSL=false";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Qwety5";

    private Connection JDBCUtilConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException utilSqlException) {
            utilSqlException.printStackTrace();
        }
        return connection;
    }

    public Connection getJDBCUtilConnection() {
        return JDBCUtilConnection();
    }

    public Session hibernateUtilConnection() {
        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/webapp?serverTimezone=Europe/Minsk&useSSL=false");
//        prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/users?serverTimezone=Europe/Minsk&useSSL=false");
        prop.setProperty("dialect", "org.hibernate.dialect.PostgresSQLDialect");
        prop.setProperty("hibernate.connection.username", "postgres");
        prop.setProperty("hibernate.connection.password", "Qwety5");
        prop.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        prop.setProperty("show_sql", String.valueOf(true));
        SessionFactory sessionFactory = new Configuration()
                .addProperties(prop).addAnnotatedClass(Customer.class).buildSessionFactory();
        return sessionFactory.openSession();
    }
}
