package service.Impl;

import model.bean.Employee;
import model.repository.IEmployeeRepository;
import model.repository.Impl.EmployeeRepositoryImpl;
import service.IEmployeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements IEmployeeService {
    IEmployeeRepository employeeRepository = new EmployeeRepositoryImpl();


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> search(String nameSearch, String emailSearch, String divisionSearch) {
        return employeeRepository.search(nameSearch, emailSearch, divisionSearch);
    }

    @Override
    public Map<String, String> insert(Employee employee) {
        // cần kiểm tra dự liệu
        // +nếu mà ok => gọi repository để lưu.
        Map<String, String> errors = new HashMap<>();
//        if(!Validation.checkPhoneNumber(employee.getPhone())) {
//            errors.put("phone", "Phone Number không đúng định dạng");
//        }
//
//        if(!Validation.checkIdCard(employee.getIdCard())) {
//            errors.put("idCard", "Id card không đúng định dạng");
//        }
//
//        if(!Validation.checkEmail(employee.getEmail())) {
//            errors.put("email", "Email không đúng định dạng");
//        }

        if (employee.getSalary() < 0) {
            errors.put("salary", "tiền lương phải lớn hơn 0");
        }

        if (errors.isEmpty()) {
            employeeRepository.insert(employee);
        }
        return errors;
    }

    @Override
    public boolean delete(int id) {
        return employeeRepository.delete(id);
    }

    @Override
    public boolean update(Employee employee) {
        return employeeRepository.update(employee);
    }

    @Override
    public Employee selectEmployee(int id) {
        return employeeRepository.selectEmployee(id);
    }
}
