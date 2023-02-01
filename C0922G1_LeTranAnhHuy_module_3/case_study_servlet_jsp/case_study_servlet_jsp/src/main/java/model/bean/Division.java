package model.bean;

public class Division {
    private int divisionId;
    private String name;

    public Division() {
    }

    public Division(int divisionId, String name) {
        this.divisionId = divisionId;
        this.name = name;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
