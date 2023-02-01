package model.repository.impl;

import model.bean.Service;
import model.repository.BaseRepository;
import model.repository.IServiceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements IServiceRepository {
    private static final String SELECT_ALL_SERVICE = "select * from service;";
    private static final String SEARCH = "select * from SERVICE where `service_name` like ? and standard_room like ?;";
    private static final String INSERT_SERVICE_SQL = "insert into service(service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors) values (?,?,?,?,?,?,?,?,?,?)";
    private static final String DELETE_SERVICE_SQL = "delete from SERVICE where SERVICE_id = ?;";
    private static final String UPDATE_SERVICE_SQL = "update SERVICE set service_name = ?,service_area = ?,service_cost = ?,service_max_people = ?,rent_type_id = ?,service_type_id = ?,standard_room = ?,description_other_convenience = ?,pool_area = ?,number_of_floors = ? where SERVICE_id = ?;";
    private static final String SELECT_SERVICE_BY_ID = "select * from SERVICE where SERVICE_id =?";

    @Override
    public List<Service> findAllService() {
        List<Service> serviceList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("service_id");
                String name = resultSet.getString("service_name");
                Integer area = resultSet.getInt("service_area");
                Double cost = resultSet.getDouble("service_cost");
                Integer maxPeople = resultSet.getInt("service_max_people");

                Integer rentTypeId = resultSet.getInt("rent_type_id");
                Integer serviceTypeId = resultSet.getInt("service_type_id");

                String standardRoom = resultSet.getString("standard_room");
                String description = resultSet.getString("description_other_convenience");
                Double poolArea = resultSet.getDouble("pool_area");
                Integer numberFloors = resultSet.getInt("number_of_floors");
                serviceList.add(new Service(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId, standardRoom, description, poolArea, numberFloors));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public List<Service> searchService(String nameSearch, String standardRoomSearch) {
        return null;
    }

    @Override
    public boolean insertService(Service service) {
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE_SQL)) {
            preparedStatement.setString(1, service.getName());
            preparedStatement.setInt(2, service.getArea());
            preparedStatement.setDouble(3, service.getCost());
            preparedStatement.setInt(4, service.getMaxPeople());
            preparedStatement.setInt(5, service.getRentTypeId());
            preparedStatement.setInt(6, service.getServiceTypeId());
            preparedStatement.setString(7, service.getStandardRoom());
            preparedStatement.setString(8, service.getDescriptionOtherConvenience());
            preparedStatement.setDouble(9, service.getPoolArea());
            preparedStatement.setInt(10, service.getNumberOfFloors());
            int update = preparedStatement.executeUpdate();
            if (update != 0) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteService(int id) {
        return false;
    }

    @Override
    public boolean updateService(Service service) {
        return false;
    }

    @Override
    public Service selectService(int id) {
        return null;
    }
}
