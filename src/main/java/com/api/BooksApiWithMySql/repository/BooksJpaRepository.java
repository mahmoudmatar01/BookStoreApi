package com.api.BooksApiWithMySql.repository;

import com.api.BooksApiWithMySql.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksJpaRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingOrAuthorContaining(String titleKeyword, String authorKeyword);

    @Query(nativeQuery = true, value = "Select * from books where quantity = '0'")
    List<Book> findOutOfStockBooks();
}
