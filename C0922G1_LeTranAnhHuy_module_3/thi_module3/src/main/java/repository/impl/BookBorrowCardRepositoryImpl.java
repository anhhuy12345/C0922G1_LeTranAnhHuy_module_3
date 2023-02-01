package repository.impl;


import model.BookBorrowCard;
import repository.BaseRepository;
import repository.IBookBorrowCardRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookBorrowCardRepositoryImpl implements IBookBorrowCardRepository {
    private static final String SELECT_ALL = "select * from book_borrow_card;";
    private static final String INSERT = "insert into book_borrow_card(book_borrow_card_id,book_id, student_id, book_borrow_card_status, book_borrow_card_start_date,book_borrow_card_end_date) values (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_BY_ID = "select * from book_borrow_card where book_borrow_card_id =?";



    @Override
    public List<BookBorrowCard> findAll() {
        List<BookBorrowCard> bookBorrowCardList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String bookBorrowCardId = resultSet.getString("book_borrow_card_id");
                String bookId = resultSet.getString("book_id");
                String studentId = resultSet.getString("student_id");
                Boolean bookBorrowCardStatus = resultSet.getBoolean("book_borrow_card_status");
                String bookBorrowCardStartDate = resultSet.getString("book_borrow_card_start_date");
                String bookBorrowCardEndDate = resultSet.getString("book_borrow_card_end_date");
                bookBorrowCardList.add(new BookBorrowCard(bookBorrowCardId, bookId, studentId, bookBorrowCardStatus, bookBorrowCardStartDate, bookBorrowCardEndDate));
            }

        } catch ( SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookBorrowCardList;
    }

    @Override
    public List<BookBorrowCard> search(String nameType, Double priceSearch, Integer floorSearch) {
        return null;
    }

    @Override
    public boolean insert(BookBorrowCard bookBorrowCard) {
        return false;
//        try (Connection connection = BaseRepository.getConnect();
//             PreparedStatement ps = connection.prepareStatement(INSERT)) {
//            ps.setString(1, bookBorrowCard.getId());
//            ps.setString(2, bookBorrowCard.getBookId());
//            ps.setString(3, bookBorrowCard.getStudentId());
//            ps.setBoolean(4, bookBorrowCard.isStatus());
//            ps.setString(5, bookBorrowCard.getStartDate());
//            ps.setString(6, bookBorrowCard.getEndDate());
//
//            int update = ps.executeUpdate();
//            if (update != 0) {
//                return true;
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(BookBorrowCard BookBorrowCard) {
        return false;
    }

    @Override
    public BookBorrowCard findById(String id) {
        return null;
//        BookBorrowCard borrowCard = null;
//        try (Connection connection = BaseRepository.getConnect();
//             // Step 2:Create a statement using connection object
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);) {
//
//            preparedStatement.setString(1, id);
//            // Step 3: Execute the query or update query
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            // Step 4: Process the ResultSet object.
//            while (resultSet.next()) {
//                String bookBorrowCardId = resultSet.getString("book_borrow_card_id");
//                String bookId = resultSet.getString("book_id");
//                String studentId = resultSet.getString("student_id");
//                Boolean bookBorrowCardStatus = resultSet.getBoolean("book_borrow_card_status");
//                String bookBorrowCardStartDate = resultSet.getString("book_borrow_card_start_date");
//                String bookBorrowCardEndDate = resultSet.getString("book_borrow_card_end_date");
//                borrowCard = new BookBorrowCard(bookBorrowCardId, bookId, studentId, bookBorrowCardStatus, bookBorrowCardStartDate, bookBorrowCardEndDate);
//
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return borrowCard;
    }
}
