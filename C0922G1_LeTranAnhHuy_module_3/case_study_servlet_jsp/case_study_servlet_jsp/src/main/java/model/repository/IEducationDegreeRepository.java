package model.repository;

import model.bean.EducationDegree;

import java.util.List;

public interface IEducationDegreeRepository {
    List<EducationDegree> findAll();
}
