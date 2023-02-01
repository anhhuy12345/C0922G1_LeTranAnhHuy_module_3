package model.repository;


import model.bean.ServiceType;

import java.util.List;

public interface IServiceTypeRepository {
    List<ServiceType> findAll();
}
