package com.api.BooksApiWithMySql.service;

import com.api.BooksApiWithMySql.exceptions.NotFoundBookCustomException;
import com.api.BooksApiWithMySql.interfaces.BaseBooksService;
import com.api.BooksApiWithMySql.models.Book;
import com.api.BooksApiWithMySql.repository.BooksJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BooksJpaService extends BaseBooksService {

    @Autowired
    private BooksJpaRepository repository;
//
//    @Autowired
//    public BooksJpaService(BooksJpaRepository repository) {
//        this.repository = repository;
//    }


    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public Book addBook(Book book) {
        repository.save(book);
        return book;
    }

    @Override
    public List<Book> searchBook(String query) {
        return repository.findByTitleContainingOrAuthorContaining(query, query);
    }

    @Override
    public Book getBookById(Long id) throws NotFoundBookCustomException {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundBookCustomException("There is no Book with that Id"));
    }

    @Override
    public Book updateBook(Long id, Book book) throws NotFoundBookCustomException {
        Book b = getBookById(id);

        // there is no exception :
        b.setTitle(book.getTitle());
        b.setAuthor(book.getAuthor());
        b.setDescription(book.getDescription());
        b.setPrice(book.getPrice());
        b.setQuantity(book.getQuantity());
        b.setId(book.getId());

        return repository.save(book);

    }

    @Override
    public Book deleteBook(Long id) throws NotFoundBookCustomException {
        Book book = getBookById(id);
        repository.delete(book);
        return book;
    }


}
