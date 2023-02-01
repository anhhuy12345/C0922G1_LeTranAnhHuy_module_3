package model.Reponsitory.Impl;

import model.Reponsitory.ICustomerRepository;
import model.bean.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository implements ICustomerRepository {
    // key là số, value là customer
    private static Map<Integer, Customer> customerList = new HashMap<>();

    static {
        customerList.put(1, new Customer(1, "Huy", "john@codegym.vn", "Hanoi"));
        customerList.put(2, new Customer(2, "Hoàng", "bill@codegym.vn", "Danang"));
        customerList.put(3, new Customer(3, "Nghĩa", "alex@codegym.vn", "Saigon"));
        customerList.put(4, new Customer(4, "Duy", "adam@codegym.vn", "Beijin"));
        customerList.put(5, new Customer(5, "Tài", "sophia@codegym.vn", "Miami"));
        customerList.put(6, new Customer(6, "Đức", "rose@codegym.vn", "Newyork"));
    }




    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerList.values());
    }

    @Override
    public void save(Customer customer) {
        customerList.put(customer.getId(), customer);
    }


    @Override
    public Customer findById(int id) {
        return customerList.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerList.put(id, customer);
    }

    @Override
    public void remove(int id) {
        customerList.remove(id);
    }
}
