package service.Impl;

import model.bean.EducationDegree;
import model.repository.IEducationDegreeRepository;
import model.repository.Impl.EducationDegreeRepositoryImpl;
import service.IEducationDegreeService;

import java.util.List;

public class EducationDegreeServiceImpl implements IEducationDegreeService {
    IEducationDegreeRepository educationDegreeRepository = new EducationDegreeRepositoryImpl();

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

}
