package model.repository;

import model.bean.ClassTeacher;

import java.util.List;

public interface IClassRepository {
    List<ClassTeacher>findAll();
}
