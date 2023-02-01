package model.repository.impl;

import model.bean.Customer;
import model.repository.BaseRepository;
import model.repository.ICustomerRepository;
import util.Validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository {
    private static final String SELECT_ALL_CUSTOMER = "select * from customer;";
    private static final String SEARCH = "select * from customer where `customer_name` like ? and `customer_email` like ? and customer_type_id like ?;";
    private static final String INSERT_CUSTOMER_SQL = "insert into customer(customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) values (?,?,?,?,?,?,?,?);";
    // xoá customer thì xoá luôn các khoá liên quan, ở đây là contract, contract liên quan đến detail_contract
    private static final String DELETE_CONTRACT_DETAIL_SQL = "delete from contract_detail where contract_id in (select contract_id from contract where customer_id = ?);";
    private static final String DELETE_CONTRACT_SQL = "delete from contract where customer_id = ?;";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?;";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set customer_type_id = ?,customer_name = ?,customer_birthday = ?,customer_gender = ?,customer_id_card = ? ,customer_phone = ?,customer_email = ?,customer_address = ? where customer_id = ?;";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id =?";


    @Override
    public List<Customer> findAllCustomer() {
        List<Customer> customerList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("customer_id");
                Integer typeId = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_name");
                String birthday = Validation.formatDate(resultSet.getString("customer_birthday"));

                Integer gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customerList.add(new Customer(id, typeId, name, birthday, gender, idCard, phone, email, address));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public List<Customer> searchCustomer(String nameSearch, String emailSearch, String typeSearch) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement ps = connection.prepareStatement(SEARCH);
            ps.setString(1, "%" + nameSearch + "%");
            ps.setString(2, "%" + emailSearch + "%");
            ps.setString(3, "%" + typeSearch + "%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("customer_id");
                Integer typeId = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                System.out.println(birthday);
                Integer gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customerList.add(new Customer(id, typeId, name, birthday, gender, idCard, phone, email, address));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public boolean insertCustomer(Customer customer) {
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement ps = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
            ps.setInt(1, customer.getTypeId());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getBirthday());
            ps.setInt(4, customer.getGender());
            ps.setString(5, customer.getIdCard());
            ps.setString(6, customer.getPhone());
            ps.setString(7, customer.getEmail());
            ps.setString(8, customer.getAddress());
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
    public boolean deleteCustomer(int id) {
        deleteContractDetail(id);
        deleteContract(id);
        Connection connection = BaseRepository.getConnect();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_SQL);) {
            preparedStatement.setInt(1, id);
            int update = preparedStatement.executeUpdate();
            if (update != 0) {
                return true;
            }
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
    public boolean updateCustomer(Customer customer) {
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement ps = connection.prepareStatement(UPDATE_CUSTOMER_SQL);) {
            ps.setInt(1, customer.getTypeId());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getBirthday());
            ps.setInt(4, customer.getGender());
            ps.setString(5, customer.getIdCard());
            ps.setString(6, customer.getPhone());
            ps.setString(7, customer.getEmail());
            ps.setString(8, customer.getAddress());
            ps.setInt(9, customer.getId());

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
    public Customer selectCustomer(int id) {
        Customer customer = null;
        try (Connection connection = BaseRepository.getConnect();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {

            preparedStatement.setInt(1, id);
            // Step 3: Execute the query or update query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (resultSet.next()) {
                Integer typeId = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                Integer gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customer = new Customer(id, typeId, name, birthday, gender, idCard, phone, email, address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }
}
