package model;

public class BookBorrowCard {
    private String id;
    private String bookId;
    private String studentId;
    private boolean status;
    private String startDate;
    private String endDate;

    public BookBorrowCard() {
    }

    public BookBorrowCard(String id, String bookId, String studentId, boolean status, String startDate, String endDate) {
        this.id = id;
        this.bookId = bookId;
        this.studentId = studentId;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
}
