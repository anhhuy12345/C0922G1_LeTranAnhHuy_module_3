package model.repository;

import model.bean.Position;

import java.util.List;

public interface IPositionRepository {
    List<Position> findAll();
}
