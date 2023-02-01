package model.service;

import model.bean.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAllUser();

    boolean insertStudent(Student student);

    boolean updateStudent(Student student);

    boolean deleteStudent(int id);

    Student selectStudent(int id);

    List<Student> searchStudent(String address);
}
