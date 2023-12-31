package com.api.BooksApiWithMySql.repository;

import com.api.BooksApiWithMySql.exceptions.NotFoundResourceCustomException;
import com.api.BooksApiWithMySql.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BooksJdbcRepository implements BaseBooksJdbcRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BooksJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book getBookById(Long id) throws NotFoundResourceCustomException {
        try {
            Book book = jdbcTemplate.queryForObject("SELECT * FROM books WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Book.class), id);

            if (book == null) {
                throw new NotFoundResourceCustomException("There is no book with that ID !!");
            }
            return book;
        } catch (IncorrectResultSizeDataAccessException e) {
            throw new NotFoundResourceCustomException("There is no book with that ID !!");
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return jdbcTemplate.query("SELECT * from books", BeanPropertyRowMapper.newInstance(Book.class));
    }

    @Override
    public int addBook(Book book) {
        return jdbcTemplate.update("INSERT INTO books (id,title, author, description, price, quantity) VALUES(?,?,?,?,?,?)",
                book.getId(), book.getTitle(), book.getAuthor(), book.getDescription(), book.getPrice(), book.getQuantity());

    }

    @Override
    public int updateBook(Long id, Book book) throws NotFoundResourceCustomException {
        getBookById(id);
        return jdbcTemplate.update("UPDATE books SET title=?, author=?, description=?,price=?,quantity=? WHERE id=?",
                book.getTitle(), book.getAuthor(), book.getDescription(), book.getPrice(), book.getQuantity() ,id);
    }

    @Override
    public int deleteBook(Long id) throws NotFoundResourceCustomException {
        getBookById(id);
        return jdbcTemplate.update("DELETE FROM books WHERE id=?", id);
    }
}
