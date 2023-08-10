package com.api.BooksApiWithMySql.service;

import com.api.BooksApiWithMySql.exceptions.NotFoundBookCustomException;
import com.api.BooksApiWithMySql.interfaces.BaseBooksService;
import com.api.BooksApiWithMySql.models.Book;
import com.api.BooksApiWithMySql.repository.BooksJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
abstract public class BooksJdbcService extends BaseBooksService {

    @Autowired
    private BooksJdbcRepository repository;

    @Override
    public List<Book> getAllBooks() {
        return repository.getAllBooks();
    }

    @Override
    public Book addBook(Book book) {
        int rows = repository.addBook(book);
        if (rows <= 0)
            return null;
        return book;
    }

    @Override
    public List<Book> searchBook(String query) {
        return null;
    }

    @Override
    public Book getBookById(Long id) throws NotFoundBookCustomException {
        return repository.getBookById(id);
    }

    @Override
    public Book updateBook(Long id, Book book) throws NotFoundBookCustomException {
        int rows = repository.updateBook(id, book);
        if (rows <= 0)
            return null;
        return book;
    }

    @Override
    public Book deleteBook(Long id) throws NotFoundBookCustomException {
        int rows = repository.deleteBook(id);
        return null;
    }
}
