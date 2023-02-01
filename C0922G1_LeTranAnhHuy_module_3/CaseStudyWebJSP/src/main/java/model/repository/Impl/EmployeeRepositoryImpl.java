package model.repository.Impl;

import model.bean.Employee;
import model.repository.BaseRepository;
import model.repository.IEmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {
    private static final String SELECT_ALL_EMPLOYEE = "select * from employee;";
    private static final String SEARCH = "select * from employee where `employee_name` like ? and `employee_email` like ? and division_id like ?;";
    private static final String INSERT_EMPLOYEE_SQL = "insert into employee(employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id, username) values (?,?,?,?,?,?,?,?,?,?,?);";
    // xoá EMPLOYEE thì xoá luôn các khoá liên quan, ở đây là contract, contract liên quan đến detail_contract
    private static final String DELETE_CONTRACT_DETAIL_SQL = "delete from contract_detail where contract_id in (select contract_id from contract where employee_id = ?);";
    private static final String DELETE_CONTRACT_SQL = "delete from contract where employee_id = ?;";
    private static final String DELETE_EMPLOYEE_SQL = "delete from employee where employee_id = ?;";

    private static final String UPDATE_EMPLOYEE_SQL = "update employee set employee_name = ?,employee_birthday = ?,employee_id_card = ?,employee_salary = ?,employee_phone = ?,employee_email = ?,employee_address = ?,position_id = ?,education_degree_id = ?,division_id = ?, username = ? where employee_id = ?;";
    private static final String SELECT_EMPLOYEE_BY_ID = "select * from employee where employee_id =?";


    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                Double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                Integer positionId = resultSet.getInt("position_id");
                Integer educationDegreeId = resultSet.getInt("education_degree_id");
                Integer divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");

                employeeList.add(new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId, username));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public List<Employee> search(String nameSearch, String emailSearch, String divisionSearch) {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement ps = connection.prepareStatement(SEARCH);
            ps.setString(1, "%" + nameSearch + "%");
            ps.setString(2, "%" + emailSearch + "%");
            ps.setString(3, "%" + divisionSearch + "%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                Double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                Integer positionId = resultSet.getInt("position_id");
                Integer educationDegreeId = resultSet.getInt("education_degree_id");
                Integer divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");

                employeeList.add(new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId, username));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public boolean insert(Employee employee) {
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement ps = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getBirthday());
            ps.setString(3, employee.getIdCard());
            ps.setDouble(4, employee.getSalary());
            ps.setString(5, employee.getPhone());
            ps.setString(6, employee.getEmail());
            ps.setString(7, employee.getAddress());
            ps.setInt(8, employee.getPositionId());
            ps.setInt(9, employee.getEducationDegreeId());
            ps.setInt(10, employee.getDivisionId());
            ps.setString(11, employee.getUsername());

            int update = ps.executeUpdate();
            if (update != 0) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean delete(int id) {
//
        Connection connection = BaseRepository.getConnect();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public void deleteContract(int id) {
        Connection connection = BaseRepository.getConnect();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CONTRACT_SQL);) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteContractDetail(int id) {
        Connection connection = BaseRepository.getConnect();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CONTRACT_DETAIL_SQL);) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean update(Employee employee) {
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement ps = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getBirthday());
            ps.setString(3, employee.getIdCard());
            ps.setDouble(4, employee.getSalary());
            ps.setString(5, employee.getPhone());
            ps.setString(6, employee.getEmail());
            ps.setString(7, employee.getAddress());
            ps.setInt(8, employee.getPositionId());
            ps.setInt(9, employee.getEducationDegreeId());
            ps.setInt(10, employee.getDivisionId());
            ps.setString(11, employee.getUsername());
            ps.setInt(12, employee.getId());

            int update = ps.executeUpdate();
            if (update != 0) {
                // thêm mới thành công
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // thêm mới thất bại
        return false;
    }

    @Override
    public Employee selectEmployee(int id) {
        Employee employee = null;
        try (Connection connection = BaseRepository.getConnect();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {

            preparedStatement.setInt(1, id);
            // Step 3: Execute the query or update query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (resultSet.next()) {
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                Double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                Integer positionId = resultSet.getInt("position_id");
                Integer educationDegreeId = resultSet.getInt("education_degree_id");
                Integer divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId, username);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }
}
