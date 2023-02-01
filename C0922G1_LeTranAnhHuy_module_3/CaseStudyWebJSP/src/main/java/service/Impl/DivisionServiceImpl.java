package service.Impl;

import model.bean.Division;
import model.repository.IDivisionRepository;
import model.repository.Impl.DivisionRepositoryImpl;
import service.IDivisionService;

import java.util.List;

public class DivisionServiceImpl implements IDivisionService {
    IDivisionRepository divisionRepository = new DivisionRepositoryImpl();
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
