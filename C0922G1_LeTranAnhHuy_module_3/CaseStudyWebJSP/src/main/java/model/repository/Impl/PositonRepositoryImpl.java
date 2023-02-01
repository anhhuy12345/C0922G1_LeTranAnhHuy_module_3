package model.repository.Impl;

import model.bean.Position;
import model.repository.BaseRepository;
import model.repository.IPositionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositonRepositoryImpl implements IPositionRepository {
    @Override
    public List<Position> findAll() {
        List<Position> positionList = new ArrayList<>();

        try(Connection connection = BaseRepository.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `position`;");) {
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer typeId =resultSet.getInt("position_id");
                String nameType = resultSet.getString("position_name");
                positionList.add(new Position(typeId, nameType));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return positionList;
    }
}
