package by.komikow.controllers;

import by.komikow.dao.Customer;
import by.komikow.services.CustomerService;
import by.komikow.services.CustomerServiceImpl;

import java.util.List;

public class CustomerController {
    private CustomerService customerService = new CustomerServiceImpl();

    public void createCustomer(String name, String email) {
        customerService.createCustomer(name, email);
    }

    public List<Customer> readCustomers() {
        return customerService.readCustomers();
    }

    public void updateEmailOfCustomer(int id, String newEmail) {
        customerService.updateEmailOfCustomer(id, newEmail);
    }

    public void deleteCustomer(int id) {
        customerService.deleteCustomer(id);
    }
}
