package model.Service.Impl;

import model.Service.ICustomerService;
import model.bean.Customer;
import model.Reponsitory.Impl.CustomerRepository;
import model.Reponsitory.ICustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {

    ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findALl() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerRepository.update(id,customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.remove(id);
    }
}
