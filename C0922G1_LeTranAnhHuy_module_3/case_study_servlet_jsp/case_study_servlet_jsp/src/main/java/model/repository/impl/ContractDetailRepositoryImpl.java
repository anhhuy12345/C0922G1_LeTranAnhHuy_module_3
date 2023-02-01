package model.repository.impl;

import model.bean.ContractDetail;
import model.bean.Customer;
import model.repository.BaseRepository;
import model.repository.IContractDetailRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepositoryImpl implements IContractDetailRepository {
    private static final String SELECT_ALL_CONTRACT_DETAIL_SQL = "select * from employee;";
    private static final String INSERT_CONTRACT_DETAIL_SQL = "insert into contract_detail(contract_id,attach_service_id,quantity) values (?,?,?)";


    @Override
    public List<ContractDetail> findAll() {
        List<ContractDetail> contractDetailList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT_DETAIL_SQL);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer contractDetailId = resultSet.getInt("contract_detail_id");
                Integer contractId = resultSet.getInt("contract_id");
                Integer attachServiceId = resultSet.getInt("attach_service_id");
                contractDetailList.add(new ContractDetail(contractDetailId, contractId, attachServiceId));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractDetailList;
    }

    @Override
    public boolean insert(ContractDetail contractDetail) {
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement ps = connection.prepareStatement(INSERT_CONTRACT_DETAIL_SQL)) {
            ps.setInt(1, contractDetail.getId());
            ps.setInt(2, contractDetail.getContractId());
            ps.setInt(3, contractDetail.getAttachServiceId());
            int update = ps.executeUpdate();
            if (update != 0) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
