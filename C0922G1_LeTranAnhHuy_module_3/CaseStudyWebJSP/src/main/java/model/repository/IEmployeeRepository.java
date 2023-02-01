package model.repository;

import model.bean.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> findAll();
    List<Employee> search(String nameSearch, String emailSearch, String divisionSearch);
    boolean insert(Employee employee);
    boolean delete(int id);
    boolean update(Employee employee);
    Employee selectEmployee(int id);
}
