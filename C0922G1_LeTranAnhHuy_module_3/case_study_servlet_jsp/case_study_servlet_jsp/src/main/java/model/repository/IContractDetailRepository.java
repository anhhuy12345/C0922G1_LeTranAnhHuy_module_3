package model.repository;
import model.bean.ContractDetail;

import java.util.List;

public interface IContractDetailRepository {
    List<ContractDetail> findAll();
    boolean insert(ContractDetail contractDetail);
}
