package model.service.impl;

import model.bean.ServiceType;
import model.repository.BaseRepository;
import model.repository.IServiceRepository;
import model.repository.IServiceTypeRepository;
import model.repository.impl.ServiceRepositoryImpl;
import model.repository.impl.ServiceTypeRepositoryImpl;
import model.service.IServiceTypeService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeServiceImpl implements IServiceTypeService {
    private IServiceTypeRepository serviceRepository = new ServiceTypeRepositoryImpl();

    @Override
    public List<ServiceType> findAll() {
        return serviceRepository.findAll();
    }
}
