package model.service;

import model.bean.ClassTeacher;

import java.util.List;

public interface IClassService {
    List<ClassTeacher> findAll();
}
