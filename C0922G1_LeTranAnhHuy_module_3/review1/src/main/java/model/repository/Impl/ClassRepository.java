package model.repository.Impl;

import model.bean.ClassTeacher;
import model.bean.Student;
import model.repository.BaseRepository;
import model.repository.IClassRepository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassRepository implements IClassRepository {
    private final String SELECT_ALL = "select * from class;";

    @Override
    public List<ClassTeacher> findAll() {
        List<ClassTeacher> classTeachers = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();

        try {
            CallableStatement callableStatement = connection.prepareCall(SELECT_ALL);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("class_id");
                String name = resultSet.getString("class_name");
                ClassTeacher classTeacher = new ClassTeacher(id,name);
                classTeacher.add(classTeacher);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return classTeachers;
    }
}
