package service.Impl;

import model.bean.Position;
import model.repository.IPositionRepository;
import model.repository.Impl.PositonRepositoryImpl;
import service.IPositionService;

import java.util.List;

public class PositionServiceImpl implements IPositionService {
    IPositionRepository positionRepository = new PositonRepositoryImpl();
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
