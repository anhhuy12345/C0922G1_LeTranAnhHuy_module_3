package model.repository.impl;

import model.bean.RentType;
import model.bean.ServiceType;
import model.repository.BaseRepository;
import model.repository.IServiceTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepositoryImpl implements IServiceTypeRepository {
    @Override
    public List<ServiceType> findAll() {
        List<ServiceType> serviceTypeList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM service_type;");) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer typeId = resultSet.getInt("service_type_id");
                String typeName = resultSet.getString("service_type_name");
                serviceTypeList.add(new ServiceType(typeId, typeName));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceTypeList;
    }
}
