package model.repository.impl;

import model.bean.RentType;
import model.repository.BaseRepository;
import model.repository.IRentTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepositoryImpl implements IRentTypeRepository {
    @Override
    public List<RentType> findAll() {
        List<RentType> rentTypeList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM rent_type;");) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer rentTypeId = resultSet.getInt("rent_type_id");
                String rentTypeName = resultSet.getString("rent_type_name");
                Double rentTypeCost = resultSet.getDouble("rent_type_cost");
                rentTypeList.add(new RentType(rentTypeId, rentTypeName, rentTypeCost));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rentTypeList;
    }
}
