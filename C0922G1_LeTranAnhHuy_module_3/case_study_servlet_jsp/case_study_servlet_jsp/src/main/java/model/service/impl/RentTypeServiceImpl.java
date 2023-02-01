package model.service.impl;

import model.bean.RentType;
import model.repository.BaseRepository;
import model.repository.IRentTypeRepository;
import model.repository.impl.RentTypeRepositoryImpl;
import model.service.IRentTypeService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeServiceImpl implements IRentTypeService {
    private IRentTypeRepository rentTypeRepository = new RentTypeRepositoryImpl();

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
