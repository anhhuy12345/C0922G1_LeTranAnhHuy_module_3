package model;

public class Student {
    private String id;
    private String name;
    private String classStudent;

    public Student() {
    }

    public Student(String id, String name, String classStudent) {
        this.id = id;
        this.name = name;
        this.classStudent = classStudent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(String classStudent) {
        this.classStudent = classStudent;
    }
}
