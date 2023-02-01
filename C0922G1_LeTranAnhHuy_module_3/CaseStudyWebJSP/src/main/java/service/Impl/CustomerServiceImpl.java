package service.Impl;

import model.bean.Customer;
import model.repository.ICustomerRepository;
import model.repository.Impl.CustomerRepositoryImpl;
import service.ICustomerService;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAllCustomer();
    }

    @Override
    public List<Customer> searchCustomer(String nameSearch, String emailSearch, String typeSearch) {
        return customerRepository.searchCustomer(nameSearch, emailSearch, typeSearch);
    }

    @Override
    public Map<String, String> insertCustomer(Customer customer) {
        // cần kiểm tra dự liệu
        // +nếu mà ok => gọi repository để lưu.
        Map<String , String> errors = new HashMap<>();

//        if(!Validation.checkDate(customer.getBirthday())) {
//            errors.put("birthday", "Birthday không đúng định dạng");
//        }

        if(errors.isEmpty()) {
            // chuyển dd/mm/yyyy thành yyyy/mm/dd để chuyển qua cho mySQL
            
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//            String birthdayFormat = LocalDate.parse(customer.getBirthday(), formatter).format(formatter2);
//            customer.setBirthday(birthdayFormat);
            customerRepository.insertCustomer(customer);
        }
        return errors;
    }

    @Override
    public boolean deleteCustomer(int id) {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerRepository.updateCustomer(customer);
    }

    @Override
    public Customer selectCustomer(int id) {
        return customerRepository.selectCustomer(id);
    }
}
