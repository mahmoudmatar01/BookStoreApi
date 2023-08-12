package com.api.BooksApiWithMySql.service;


import com.api.BooksApiWithMySql.exceptions.NotFoundResourceCustomException;
import com.api.BooksApiWithMySql.interfaces.BaseBooksService;
import com.api.BooksApiWithMySql.interfaces.BaseRepository;
import com.api.BooksApiWithMySql.models.Book;
import com.api.BooksApiWithMySql.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
abstract public class BooksService extends BaseBooksService {

    private final BaseRepository<Book> repository;

    @Autowired
    public BooksService(BooksRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Book> getAllBooks() {
        return repository.getAll();
    }

    @Override
    public Book addBook(Book book) {
        repository.add(book);
        return book;
    }

    @Override
    public List<Book> searchBook(String query) {
        return repository.search(query);
    }

    @Override
    public Book getBookById(Long id) throws NotFoundResourceCustomException {
        return repository.getById(id);
    }

    @Override
    public Book updateBook(Long id, Book book) throws NotFoundResourceCustomException {
        return null;
    }

    @Override
    public Book deleteBook(Long id) throws NotFoundResourceCustomException {
        return null;
    }
}
