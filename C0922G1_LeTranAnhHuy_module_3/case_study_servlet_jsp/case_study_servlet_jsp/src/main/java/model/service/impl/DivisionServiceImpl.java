package model.service.impl;

import model.bean.Division;
import model.repository.IDivisionRepository;
import model.repository.impl.DivisionRepositoryImpl;
import model.service.IDivisionService;

import java.util.List;

public class DivisionServiceImpl implements IDivisionService {
    IDivisionRepository divisionRepository = new DivisionRepositoryImpl();
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
