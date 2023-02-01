package model.service;

import model.bean.Teacher;

import java.util.List;

public interface ITeacherService {
    List<Teacher> findAll();

    boolean insertTeacher(Teacher teacher);

    boolean updateTeacher(Teacher teacher);

    boolean deleteTeacher(int id);

    Teacher selectTeacher(int id);

    List<Teacher> searchTeacher(String address);
}
