package model.repository;

import model.bean.Student;
import model.bean.Teacher;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAllUser();

    boolean insertStudent(Student student);

    boolean updateStudent(Student student);

    boolean deleteStudent(int id);

    Student selectStudent(int id);

    List<Student> searchStudent(String address);
}
