package model;

public class Book {
    private String id;
    private String name;
    private String author;
    private String describe;
    private Integer quantity;

    public Book() {
    }

    public Book(String id, String name, String author, String describe, Integer quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.describe = describe;
        this.quantity = quantity;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
