package service.Impl;

import model.bean.Service;
import model.repository.IServiceRepository;
import model.repository.Impl.ServiceRepositoryImpl;
import service.IServiceService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceServiceImpl implements IServiceService {
    private IServiceRepository serviceRepository = new ServiceRepositoryImpl();

    @Override
    public List<Service> findAllService() {
        return serviceRepository.findAllService();
    }

    @Override
    public List<Service> searchService(String nameSearch, String standardRoomSearch) {
        return serviceRepository.searchService(nameSearch, standardRoomSearch);
    }

    @Override
    public Map<String, String> insertService(Service service) {
        Map<String, String> map = new HashMap<>();
        if (service.getNumberOfFloors() < 0) {
            map.put("numberFloor", "Số tầng phải lớn hơn 0");
        }

        if (map.isEmpty()) {
            serviceRepository.insertService(service);
        }
        return map;
    }

    @Override
    public boolean deleteService(int id) {
        return serviceRepository.deleteService(id);
    }

    @Override
    public boolean updateService(Service service) {
        return serviceRepository.updateService(service);
    }

    @Override
    public Service selectService(int id) {
        return serviceRepository.selectService(id);
    }
}
