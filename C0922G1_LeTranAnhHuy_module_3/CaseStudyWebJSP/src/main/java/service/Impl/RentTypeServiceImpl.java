package service.Impl;

import model.bean.RentType;
import model.repository.IRentTypeRepository;
import model.repository.Impl.RentTypeRepositoryImpl;
import service.IRentTypeService;

import java.util.List;

public class RentTypeServiceImpl implements IRentTypeService {
    private IRentTypeRepository rentTypeRepository = new RentTypeRepositoryImpl();

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
