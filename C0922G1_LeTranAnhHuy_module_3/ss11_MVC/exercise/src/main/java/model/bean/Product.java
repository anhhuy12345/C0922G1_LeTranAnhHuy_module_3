package model.bean;

public class Product {
    private int id;
    private String name;
    private double cost;
    private String describe;
    private String nameProducer;

    public Product() {
    }

    public Product(int id, String name, double cost, String describe, String nameProducer) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.describe = describe;
        this.nameProducer = nameProducer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getNameProducer() {
        return nameProducer;
    }

    public void setNameProducer(String nameProducer) {
        this.nameProducer = nameProducer;
    }
}
