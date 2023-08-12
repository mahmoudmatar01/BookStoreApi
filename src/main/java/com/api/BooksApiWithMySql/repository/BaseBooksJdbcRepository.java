package com.api.BooksApiWithMySql.repository;

import com.api.BooksApiWithMySql.exceptions.NotFoundResourceCustomException;
import com.api.BooksApiWithMySql.models.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseBooksJdbcRepository {
    Book getBookById(Long id) throws NotFoundResourceCustomException;

    List<Book> getAllBooks();

    int addBook(Book book);

    int updateBook(Long id, Book book) throws NotFoundResourceCustomException;

    int deleteBook(Long id) throws NotFoundResourceCustomException;
}
