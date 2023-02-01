package model.repository.Impl;

import model.bean.Division;
import model.repository.BaseRepository;
import model.repository.IDivisionRepository;
import service.IDivisionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepositoryImpl implements IDivisionRepository {
    @Override
    public List<Division> findAll() {
        List<Division> divisionList = new ArrayList<>();

        try(Connection connection = BaseRepository.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from division;");) {
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer typeId =resultSet.getInt("division_id");
                String nameType = resultSet.getString("division_name");
                divisionList.add(new Division(typeId, nameType));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return divisionList;
    }
}
