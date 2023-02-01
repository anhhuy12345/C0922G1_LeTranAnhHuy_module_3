package model.service;


import model.bean.Service;

import java.util.List;
import java.util.Map;

public interface IServiceService {
    List<Service> findAllService();
    List<Service> searchService(String nameSearch, String standardRoomSearch);
    Map<String, String> insertService(Service service);
    boolean deleteService(int id);
    boolean updateService(Service service);
    Service selectService(int id);
}
