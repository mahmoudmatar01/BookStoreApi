package com.api.BooksApiWithMySql;

import com.api.BooksApiWithMySql.models.Book;
import com.api.BooksApiWithMySql.repository.BooksJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BooksJpaRepositoryUnitTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    BooksJpaRepository repository;


    @Test
    public void findBooksByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase_findBooks_acceptActiveStrings() {
        /// AAA : Arrange - Act - Assert

        // Arrange
        Book b1 = new Book("Book 1" ,"Auth 1" ,"Desc 1" ,10 ,1);
        Book b2 = new Book("B 2" ,"Auth 2" ,"Desc 1" ,10 ,1);
        Book b3 = new Book("B 3" ,"Auth 3" ,"Desc 1" ,10 ,1);
        entityManager.persist(b1);
        entityManager.persist(b2);
        entityManager.persist(b3);


        // Act
        List<Book> books1 =repository
                .findBooksByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(
                        "b 2","auth 2"
                ); // 1

        List<Book> books2 =repository
                .findBooksByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(
                        "b","auth 2"
                ); // 3

        List<Book> books3 =repository
                .findBooksByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(
                        "b 2","auth 3"
                ); // 2

        // Assert
        assertThat(books1).hasSize(1).contains(b2);
        assertThat(books2).hasSize(3).contains(b1,b2,b3);
        assertThat(books3).hasSize(2).contains(b2,b3);
    }


    @Test
    public void findBooksByPriceBetweenOrderByPriceDesc_containsDescBooks_acceptActiveBooks(){

        // Arrange
        Book b1 = new Book("Book 1" ,"Auth 1" ,"Desc 1" ,10 ,1);
        Book b2 = new Book("B 2" ,"Auth 2" ,"Desc 2" ,20 ,1);
        Book b3 = new Book("B 3" ,"Auth 3" ,"Desc 3" ,50 ,1);
        Book b4 = new Book("B 4" ,"Auth 4" ,"Desc 4" ,100 ,1);
        entityManager.persist(b1);
        entityManager.persist(b2);
        entityManager.persist(b3);
        entityManager.persist(b4);


        // Act
        List<Book> books = repository.findBooksByPriceBetweenOrderByPriceDesc(20,60);
        List<Book> emptyBooks = repository.findBooksByPriceBetweenOrderByPriceDesc(200 ,300);


        // Assert
        assertThat(books).hasSize(2).contains(b2,b3);
        assertThat(books.get(0)).isEqualTo(b3);
        assertThat(emptyBooks).isEmpty();
    }



    @Test
    public void findBookByTitleLike_returnsOneBookWithTitle(){
        // Arrange
        Book b1 = new Book("Book 1" ,"Auth 1" ,"Desc 1" ,10 ,1);
        Book b2 = new Book("B 2" ,"Auth 2" ,"Desc 2" ,20 ,1);
        Book b3 = new Book("B 3" ,"Auth 3" ,"Desc 3" ,50 ,1);
        Book b4 = new Book("B 4" ,"Auth 4" ,"Desc 4" ,100 ,1);
        entityManager.persist(b1);
        entityManager.persist(b2);
        entityManager.persist(b3);
        entityManager.persist(b4);

        // Act
        Book book = repository.findBookByTitleLike("B 2");
        Book bookEmpty = repository.findBookByTitleLike("B 28");


        // Assert
        assertThat(bookEmpty).isNull();
        assertThat(book).isEqualTo(b2);

    }

    @Test
    public void findBookByAuthorLikeOrderByPriceDesc_validAuthor_returnListOfBooks(){
        // Arrange
        Book b1 = new Book("Book 1" ,"Auth 1" ,"Desc 1" ,10 ,1);
        Book b2 = new Book("B 2" ,"Auth 1" ,"Desc 2" ,20 ,1);
        Book b3 = new Book("B 3" ,"Auth 3" ,"Desc 3" ,50 ,1);
        Book b4 = new Book("B 4" ,"Auth 4" ,"Desc 4" ,100 ,1);
        entityManager.persist(b1);
        entityManager.persist(b2);
        entityManager.persist(b3);
        entityManager.persist(b4);


        // Act
        List<Book> books = repository.findBookByAuthorLikeOrderByPriceDesc("Auth 1");

        // Assert
        assertThat(books).hasSize(2).contains(b1,b2);
        assertThat(books.get(0)).isEqualTo(b2);
    }
}
