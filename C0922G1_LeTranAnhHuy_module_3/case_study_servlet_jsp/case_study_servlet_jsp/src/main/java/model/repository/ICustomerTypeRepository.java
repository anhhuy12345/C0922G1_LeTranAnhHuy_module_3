package model.repository;

import model.bean.CustomerType;

import java.util.List;

public interface ICustomerTypeRepository {
    List<CustomerType> findAll();
}
