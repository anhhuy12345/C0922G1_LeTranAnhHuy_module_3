package model.service.impl;

import model.bean.ContractDetail;
import model.repository.IContractDetailRepository;
import model.repository.impl.ContractDetailRepositoryImpl;
import model.service.IContractDetailService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContractDetailServiceImpl implements IContractDetailService {
    IContractDetailRepository contractDetailRepository = new ContractDetailRepositoryImpl();

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public Map<String, String> insert(ContractDetail contractDetail) {
        Map<String, String> map = new HashMap<>();
        if (contractDetail.getQuantity() < 0) {
            map.put("quantity", "số lượng phải lớn 0");
        }
        if (map.isEmpty()) {
            contractDetailRepository.insert(contractDetail);
        }
        return map;
    }
}
