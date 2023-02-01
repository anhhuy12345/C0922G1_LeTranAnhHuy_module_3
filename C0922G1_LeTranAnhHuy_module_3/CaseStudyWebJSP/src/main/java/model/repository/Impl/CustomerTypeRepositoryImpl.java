package model.repository.Impl;

import model.bean.CustomerType;
import model.repository.BaseRepository;
import model.repository.ICustomerTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements ICustomerTypeRepository {

    @Override
    public List<CustomerType> findAll() {
        List<CustomerType> customerTypeList = new ArrayList<>();

        try(Connection connection = BaseRepository.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from customer_type;");) {
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer typeId =resultSet.getInt("customer_type_id");
                String nameType = resultSet.getString("customer_type_name");
                customerTypeList.add(new CustomerType(typeId, nameType));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerTypeList;
    }
}
