package model.repository.impl;

import model.bean.AttachService;
import model.bean.CustomerType;
import model.repository.BaseRepository;
import model.repository.IAttachServiceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachServiceRepositoryImpl implements IAttachServiceRepository {
    @Override
    public List<AttachService> findAll() {
        List<AttachService> attachServiceList = new ArrayList<>();

        try(Connection connection = BaseRepository.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from attach_service;");) {
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id =resultSet.getInt("attach_service_id");
                String serviceName = resultSet.getString("attach_service_name");
                Double serviceCost = resultSet.getDouble("attach_service_cost");
                String serviceUnit = resultSet.getString("attach_service_unit");
                String serviceStatus = resultSet.getString("attach_service_status");
                attachServiceList.add(new AttachService(id, serviceName, serviceCost, serviceUnit, serviceStatus));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return attachServiceList;
    }
}
