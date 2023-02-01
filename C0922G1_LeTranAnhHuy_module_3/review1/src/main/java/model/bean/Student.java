package model.bean;

public class Student {
    private Integer id;
    private String name;
    private String birthday;
    private String address;
    private ClassTeacher classTeacher;
    public Student() {
    }

    public Student(String name, String birthday, String address,ClassTeacher classTeacher) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.classTeacher = classTeacher;
    }

    public Student(Integer id, String name, String birthday, String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;

        this.address = address;
    }

    public ClassTeacher getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(ClassTeacher classTeacher) {
        this.classTeacher = classTeacher;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
