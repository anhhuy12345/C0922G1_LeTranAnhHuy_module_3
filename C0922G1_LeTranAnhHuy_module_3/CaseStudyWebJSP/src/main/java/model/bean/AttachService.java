package model.bean;

public class AttachService {
    private Integer id;
    private String name;
    private Double service;
    private String unit;
    private String status;

    public AttachService() {
    }

    public AttachService(Integer id, String name, Double service, String unit, String status) {
        this.id = id;
        this.name = name;
        this.service = service;
        this.unit = unit;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getService() {
        return service;
    }

    public void setService(Double service) {
        this.service = service;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
