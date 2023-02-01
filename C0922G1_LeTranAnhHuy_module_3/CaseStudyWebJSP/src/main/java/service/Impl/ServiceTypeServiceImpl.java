package service.Impl;

import model.bean.ServiceType;
import model.repository.IServiceTypeRepository;
import model.repository.Impl.ServiceTypeRepositoryImpl;
import service.IServiceTypeService;

import java.util.List;

public class ServiceTypeServiceImpl implements IServiceTypeService {
    private IServiceTypeRepository serviceRepository = new ServiceTypeRepositoryImpl();

    @Override
    public List<ServiceType> findAll() {
        return serviceRepository.findAll();
    }
}
