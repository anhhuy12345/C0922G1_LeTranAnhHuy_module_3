package model.repository;

import model.bean.Contract;

import java.util.List;

public interface IContractRepository {
    List<Contract> findAll();
    boolean insert(Contract contract);
}
