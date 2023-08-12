package com.api.BooksApiWithMySql.interfaces;

import com.api.BooksApiWithMySql.exceptions.NotFoundResourceCustomException;
import com.api.BooksApiWithMySql.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class BaseBooksService {
    abstract public List<Book> getAllBooks();

    abstract public Book addBook(Book book);

    abstract public List<Book> searchBook(String query);

    abstract public Book getBookById(Long id) throws NotFoundResourceCustomException;

    abstract public Book updateBook(Long id, Book book) throws NotFoundResourceCustomException;

    abstract public Book deleteBook(Long id) throws NotFoundResourceCustomException;

    abstract public List<Book> findBooksWithPriceBetween(double start, double end);

    abstract public Book findBooksByTitle(String title);

    abstract public List<Book> findBooksByAuthor(String author);
}
