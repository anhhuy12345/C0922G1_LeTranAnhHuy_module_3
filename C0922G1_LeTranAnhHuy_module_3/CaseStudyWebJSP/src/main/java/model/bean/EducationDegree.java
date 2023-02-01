package model.bean;

public class EducationDegree {
    private int educationDegreeId;
    private String name;

    public EducationDegree() {
    }

    public EducationDegree(int educationDegreeId, String name) {
        this.educationDegreeId = educationDegreeId;
        this.name = name;
    }

    public int getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
