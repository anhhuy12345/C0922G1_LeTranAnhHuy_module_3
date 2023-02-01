package repository.impl;


import model.Book;
import repository.BaseRepository;
import repository.IBookRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements IBookRepository {
    private static final String SELECT_BY_ID = "select * from book where book_id = ?";

    @Override
    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();

        Connection connection = BaseRepository.getConnect();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from sach;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String bookId = resultSet.getString("ma_sach");
                String bookName = resultSet.getString("ten_sach");
                String author = resultSet.getString("tac_gia");
                String describe = resultSet.getString("mo_ta");
                Integer quantity = resultSet.getInt("so_luong");
                bookList.add(new Book(bookId, bookName, author, describe, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookList;
    }

    @Override
    public Book findById(String id) {
        Book book = null;
        try (Connection connection = BaseRepository.getConnect();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);) {

            preparedStatement.setString(1, id);
            // Step 3: Execute the query or update query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (resultSet.next()) {
                String bookId = resultSet.getString("ma_sach");
                String name = resultSet.getString("ten_sach");
                String author = resultSet.getString("tac_gia");
                String describe = resultSet.getString("mo_ta");
                Integer quantity = resultSet.getInt("so_luong");
                book = new Book(bookId, name, author, describe, quantity);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return book;
    }
}