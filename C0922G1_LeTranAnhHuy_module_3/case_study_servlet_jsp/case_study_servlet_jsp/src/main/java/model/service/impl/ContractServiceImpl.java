package model.service.impl;

import model.bean.Contract;
import model.bean.ContractDetail;
import model.repository.IContractRepository;
import model.repository.impl.ContractRepositoryImpl;
import model.service.IContractDetailService;
import model.service.IContractService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContractServiceImpl implements IContractService {
    IContractRepository contractRepository = new ContractRepositoryImpl();

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Map<String, String> insert(Contract contract) {
        Map<String, String> map = new HashMap<>();
        if (contract.getDeposit() < 0) {
            map.put("deposit", "tiền đặt cọc phải lơn hơn 0");
        }

        if (contract.getTotalMoney() < 0) {
            map.put("totalMoney", "tổng tiền phải lơn hơn 0");
        }

        if (map.isEmpty()) {
            contractRepository.insert(contract);
        }
        return map;
    }
}
