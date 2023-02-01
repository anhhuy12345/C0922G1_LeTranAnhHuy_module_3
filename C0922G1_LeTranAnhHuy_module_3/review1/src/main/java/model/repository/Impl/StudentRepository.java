package model.repository.Impl;

import model.bean.Student;
import model.repository.BaseRepository;
import model.repository.IStudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static final String FIND_ALL = "select * from student";
    private static final String INSERT_INTO = "insert into student(name, birthday, address,class_id) values(?,?,?,?)";
    @Override
    public List<Student> findAllUser() {
        List<Student>studentList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(FIND_ALL);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("birthday");
                String address = resultSet.getString("address");
                studentList.add(new Student(id, name,birthday,address));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentList;
    }

    @Override
    public boolean insertStudent(Student student) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2, student.getBirthday());
            preparedStatement.setString(3, student.getAddress());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean updateStudent(Student student) {
        return false;
    }

    @Override
    public boolean deleteStudent(int id) {
        return false;
    }

    @Override
    public Student selectStudent(int id) {
        return null;
    }

    @Override
    public List<Student> searchStudent(String address) {
        return null;
    }
}
