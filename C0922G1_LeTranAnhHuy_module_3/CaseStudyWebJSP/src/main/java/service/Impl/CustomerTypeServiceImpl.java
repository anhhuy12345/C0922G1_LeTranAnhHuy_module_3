package service.Impl;

import model.bean.CustomerType;
import model.repository.ICustomerTypeRepository;
import model.repository.Impl.CustomerTypeRepositoryImpl;
import service.ICustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImpl implements ICustomerTypeService {
    private ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
