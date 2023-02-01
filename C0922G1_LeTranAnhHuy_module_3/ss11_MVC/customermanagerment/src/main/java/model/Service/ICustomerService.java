package model.Service;

import model.bean.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findALl();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
