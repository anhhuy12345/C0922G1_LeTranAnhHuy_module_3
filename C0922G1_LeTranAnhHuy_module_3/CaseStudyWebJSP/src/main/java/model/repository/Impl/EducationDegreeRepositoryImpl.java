package model.repository.Impl;

import model.bean.EducationDegree;
import model.repository.BaseRepository;
import model.repository.IEducationDegreeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepositoryImpl implements IEducationDegreeRepository {
    @Override
    public List<EducationDegree> findAll() {
        List<EducationDegree> educationDegreeList = new ArrayList<>();

        try(Connection connection = BaseRepository.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM education_degree;");) {
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer typeId =resultSet.getInt("education_degree_id");
                String nameType = resultSet.getString("education_degree_name");
                educationDegreeList.add(new EducationDegree(typeId, nameType));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educationDegreeList;
    }
}
