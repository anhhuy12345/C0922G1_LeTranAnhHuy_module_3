package model.repository.Impl;

import model.bean.Teacher;
import model.repository.IteacherRepository;
import model.service.ITeacherService;

import java.util.List;

public class TeacherRepository implements IteacherRepository {
    @Override
    public List<Teacher> findAll() {
        return null;
    }

    @Override
    public boolean insertTeacher(Teacher teacher) {
        return false;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        return false;
    }

    @Override
    public boolean deleteTeacher(int id) {
        return false;
    }

    @Override
    public Teacher selectTeacher(int id) {
        return null;
    }

    @Override
    public List<Teacher> searchTeacher(String address) {
        return null;
    }
}
