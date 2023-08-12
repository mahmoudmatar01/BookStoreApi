package com.api.BooksApiWithMySql.service;

import com.api.BooksApiWithMySql.exceptions.NotFoundResourceCustomException;
import com.api.BooksApiWithMySql.interfaces.BaseBooksService;
import com.api.BooksApiWithMySql.models.Book;
import com.api.BooksApiWithMySql.repository.BooksJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BooksJpaService extends BaseBooksService {

    @Autowired
    private BooksJpaRepository repository;

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
    public Book getBookById(Long id) throws NotFoundResourceCustomException {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundResourceCustomException("There is no Book with that Id"));
    }

    @Override
    public Book updateBook(Long id, Book book) throws NotFoundResourceCustomException {
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
    public Book deleteBook(Long id) throws NotFoundResourceCustomException {
        Book book = getBookById(id);
        repository.delete(book);
        return book;
    }

    @Override
    public List<Book> findBooksWithPriceBetween(double start, double end) {
        return repository.findBooksByPriceBetweenOrderByPriceDesc(start,end);
    }

    @Override
    public List<Book> findBooksByTitle(String title) {
       return repository.findBookByTitleLikeOrderByPriceDesc(title);
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
       return repository.findBookByAuthorLikeOrderByPriceDesc(author);
    }


}
