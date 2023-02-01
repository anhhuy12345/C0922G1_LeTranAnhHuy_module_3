package repository;


import model.Book;

import java.util.List;

public interface IBookRepository {
    List<Book> findAll();
    Book findById(String id);
}
