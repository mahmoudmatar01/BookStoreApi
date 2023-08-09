package com.api.BooksApiWithMySql.repository;

import com.api.BooksApiWithMySql.exceptions.NotFoundBookCustomException;
import com.api.BooksApiWithMySql.models.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseBooksJdbcRepository {
    Book getBookById(Long id) throws NotFoundBookCustomException;

    List<Book> getAllBooks();

    int addBook(Book book);

    int updateBook(Long id, Book book) throws NotFoundBookCustomException;

    int deleteBook(Long id) throws NotFoundBookCustomException;
}
