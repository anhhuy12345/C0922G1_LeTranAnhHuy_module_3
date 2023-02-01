package model.repository;

import model.bean.Division;

import java.util.List;

public interface IDivisionRepository {
    List<Division> findAll();
}
