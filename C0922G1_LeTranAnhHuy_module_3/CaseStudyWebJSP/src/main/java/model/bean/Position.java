package model.bean;

public class Position {
    private Integer positionId;
    private String name;

    public Position() {
    }

    public Position(Integer positionId, String name) {
        this.positionId = positionId;
        this.name = name;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
