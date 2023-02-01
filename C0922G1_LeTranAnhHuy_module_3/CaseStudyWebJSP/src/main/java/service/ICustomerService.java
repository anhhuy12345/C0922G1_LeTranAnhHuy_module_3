package service;

import model.bean.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<Customer> findAllCustomer();
    List<Customer> searchCustomer(String nameSearch, String emailSearch, String typeSearch);
    Map<String, String> insertCustomer(Customer customer);
    boolean deleteCustomer(int id);
    boolean updateCustomer(Customer customer);
    Customer selectCustomer(int id);
}
