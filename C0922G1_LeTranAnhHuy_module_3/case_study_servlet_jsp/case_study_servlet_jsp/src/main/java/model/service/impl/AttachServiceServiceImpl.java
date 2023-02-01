package model.service.impl;

import model.bean.AttachService;
import model.repository.IAttachServiceRepository;
import model.repository.impl.AttachServiceRepositoryImpl;
import model.service.IAttachServiceService;

import java.util.List;

public class AttachServiceServiceImpl implements IAttachServiceService {
    IAttachServiceRepository attachServiceRepository = new AttachServiceRepositoryImpl();

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
