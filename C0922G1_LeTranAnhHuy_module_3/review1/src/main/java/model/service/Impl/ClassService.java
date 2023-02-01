package model.service.Impl;

import model.bean.ClassTeacher;
import model.repository.IClassRepository;
import model.repository.Impl.ClassRepository;
import model.service.IClassService;

import java.util.List;

public class ClassService implements IClassService {
    IClassRepository classRepository = new ClassRepository();
    @Override
    public List<ClassTeacher> findAll() {
        return classRepository.findAll();
    }
}
