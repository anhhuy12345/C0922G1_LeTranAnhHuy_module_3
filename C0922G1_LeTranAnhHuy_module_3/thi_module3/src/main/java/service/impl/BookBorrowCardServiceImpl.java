package service.impl;




import model.BookBorrowCard;
import repository.IBookBorrowCardRepository;
import repository.IBookRepository;
import repository.impl.BookBorrowCardRepositoryImpl;
import service.IBookBorrowCardService;

import java.util.List;

public class BookBorrowCardServiceImpl implements IBookBorrowCardService {
  IBookBorrowCardRepository bookBorrowCardRepository = new BookBorrowCardRepositoryImpl();

    @Override
    public List<BookBorrowCard> findAll() {
        return null;
//        return borrowCardRepository.findAll();
    }

    @Override
    public List<BookBorrowCard> search(String nameType, Double priceSearch, Integer floorSearch) {
        return null;
    }

    @Override
    public boolean insert(BookBorrowCard bookBorrowCard) {
        return bookBorrowCardRepository.insert(bookBorrowCard);
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
    }
}
