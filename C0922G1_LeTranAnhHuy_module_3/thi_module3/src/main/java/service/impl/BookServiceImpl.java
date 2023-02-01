package service.impl;

import model.Book;
import repository.IBookRepository;
import repository.impl.BookRepositoryImpl;
import service.IBookService;

import java.util.List;

public class BookServiceImpl implements IBookService {
    private IBookRepository bookRepository = new BookRepositoryImpl();
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(String id) {
        return bookRepository.findById(id);
    }
}
