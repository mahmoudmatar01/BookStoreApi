package com.api.BooksApiWithMySql.interfaces;

import com.api.BooksApiWithMySql.exceptions.NotFoundBookCustomException;
import com.api.BooksApiWithMySql.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class BaseBooksService {
    abstract public List<Book> getAllBooks();

    abstract public Book addBook(Book book);

    abstract public List<Book> searchBook(String query);

    abstract public Book getBookById(Long id) throws NotFoundBookCustomException;

    abstract public Book updateBook(Long id, Book book) throws NotFoundBookCustomException;

    abstract public Book deleteBook(Long id) throws NotFoundBookCustomException;
}
