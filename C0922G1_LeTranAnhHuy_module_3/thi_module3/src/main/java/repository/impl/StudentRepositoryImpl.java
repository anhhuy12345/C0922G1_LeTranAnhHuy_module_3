package repository.impl;

import model.Student;

import repository.BaseRepository;
import repository.IStudentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements IStudentRepository {
    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from student;");) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String studentId= resultSet.getString("student_id");
                String studentName = resultSet.getString("student_name");
                String studentClass = resultSet.getString("student_class");
                studentList.add(new Student(studentId, studentName, studentClass));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
