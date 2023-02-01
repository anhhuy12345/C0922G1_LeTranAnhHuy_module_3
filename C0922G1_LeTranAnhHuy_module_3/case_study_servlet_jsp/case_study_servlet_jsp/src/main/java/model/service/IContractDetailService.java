package model.service;
import model.bean.ContractDetail;

import java.util.List;
import java.util.Map;

public interface IContractDetailService {
    List<ContractDetail> findAll();
    Map<String, String> insert(ContractDetail contractDetail);
}
