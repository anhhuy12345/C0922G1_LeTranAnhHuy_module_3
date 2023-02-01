package model.service.impl;

import model.bean.Position;
import model.repository.IPositionRepository;
import model.repository.impl.PositionRepositoryImpl;
import model.service.IPositionService;

import java.util.List;

public class PositionServiceImpl implements IPositionService {
    IPositionRepository positionRepository = new PositionRepositoryImpl();
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
