package com.api.BooksApiWithMySql.repository;

import com.api.BooksApiWithMySql.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksJpaRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingOrAuthorContaining(String titleKeyword, String authorKeyword);

//    @Query(nativeQuery = true, value = "Select * from books where quantity = '0'")
//    List<Book> findOutOfStockBooks();

    @Query("SELECT t FROM Book t WHERE t.price BETWEEN :start AND :end order by t.price DESC ")
    List<Book> findBooksBetweenPrice(@Param("start") double start, @Param("end") double end);

    @Query("select t from Book t where t.author like %:author_name% ORDER BY t.price desc ")
    List<Book> findBookByAuthor(@Param("author_name") String author);

    List<Book> findBooksByPriceBetweenOrderByPriceDesc(double price, double price2);

    List<Book> findBookByTitleLikeOrderByPriceDesc(String title);

    List<Book> findBookByAuthorLikeOrderByPriceDesc(String author);
}
