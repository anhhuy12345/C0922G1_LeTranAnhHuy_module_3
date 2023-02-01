package model.bean;

public class Contract {
    private Integer id;
    private String startDate;
    private String endDate;
    private Double deposit;
    private Double totalMoney;
    private Integer employeeId;
    private Integer customerId;
    private Integer serviceId;

    public Contract() {
    }

    public Contract(Integer id, String startDate, String endDate, Double deposit, Double totalMoney, Integer employeeId, Integer customerId, Integer serviceId) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public Contract(String startDate, String endDate, Double deposit, Double totalMoney, Integer employeeId, Integer customerId, Integer serviceId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }
}
