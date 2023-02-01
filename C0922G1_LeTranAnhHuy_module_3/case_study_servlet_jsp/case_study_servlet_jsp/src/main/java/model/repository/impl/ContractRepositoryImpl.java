package model.repository.impl;

import model.bean.Contract;
import model.bean.ContractDetail;
import model.repository.BaseRepository;
import model.repository.IContractRepository;
import util.Validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImpl implements IContractRepository {
    private static final String SELECT_ALL_CONTRACT_SQL = "select * from contract;";
    private static final String INSERT_CONTRACT_SQL = "insert into contract(contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id) values (?,?,?,?,?,?,?)";

    @Override
    public List<Contract> findAll() {
        List<Contract> contractList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT_SQL);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer contractId = resultSet.getInt("contract_id");
                String contractStartDate = Validation.formatDateContract(resultSet.getString("contract_start_date"));
                String contractEndDate = Validation.formatDateContract(resultSet.getString("contract_end_date"));
                Double contractDeposit = resultSet.getDouble("contract_deposit");
                Double contractTotalMoney = resultSet.getDouble("contract_total_money");
                Integer employeeId = resultSet.getInt("employee_id");
                Integer customerId = resultSet.getInt("customer_id");
                Integer serviceId = resultSet.getInt("service_id");

                contractList.add(new Contract(contractId, contractStartDate, contractEndDate, contractDeposit, contractTotalMoney, employeeId, customerId, serviceId));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractList;
    }

    @Override
    public boolean insert(Contract contract) {
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement ps = connection.prepareStatement(INSERT_CONTRACT_SQL)) {
            ps.setString(1, contract.getStartDate());
            ps.setString(2, contract.getEndDate());
            ps.setDouble(3, contract.getDeposit());
            ps.setDouble(4, contract.getTotalMoney());
            ps.setInt(5, contract.getEmployeeId());
            ps.setInt(6, contract.getCustomerId());
            ps.setInt(7, contract.getServiceId());
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
