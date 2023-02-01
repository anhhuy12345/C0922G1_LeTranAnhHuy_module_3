package model.bean;

public class ClassTeacher {
    private int id;
    private String name;

    public ClassTeacher() {
    }

    public ClassTeacher(int id) {
        this.id = id;
    }

    public ClassTeacher(int id, String name) {
        this.id = id;
        this.name = name;
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

    public void add(ClassTeacher classTeacher) {
    }
}
