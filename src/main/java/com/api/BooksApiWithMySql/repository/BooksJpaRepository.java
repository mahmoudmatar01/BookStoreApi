package com.api.BooksApiWithMySql.repository;

import com.api.BooksApiWithMySql.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksJpaRepository extends JpaRepository<Book, Long> {
    List<Book> findBooksByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(String title, String author);

    List<Book> findBooksByPriceBetweenOrderByPriceDesc(double price, double price2);

    Book findBookByTitleLike(String title);

    List<Book> findBookByAuthorLikeOrderByPriceDesc(String author);
}
