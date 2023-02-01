package model.service.impl;

import model.bean.EducationDegree;
import model.repository.IEducationDegreeRepository;
import model.repository.impl.EducationDegreeRepositoryImpl;
import model.service.IEducationDegreeService;
import model.service.IEmployeeService;

import java.util.List;

public class EducationDegreeServiceImpl implements IEducationDegreeService {
    IEducationDegreeRepository educationDegreeRepository = new EducationDegreeRepositoryImpl();

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
