package model.service;



import model.bean.Employee;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    List<Employee> findAll();
    List<Employee> search(String nameSearch, String emailSearch, String divisionSearch);
    Map<String, String> insert(Employee employee);
    boolean delete(int id);
    boolean update(Employee employee);
    Employee selectEmployee(int id);
}
