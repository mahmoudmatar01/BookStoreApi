package com.api.BooksApiWithMySql.repository;

import com.api.BooksApiWithMySql.exceptions.NotFoundResourceCustomException;
import com.api.BooksApiWithMySql.interfaces.BaseRepository;
import com.api.BooksApiWithMySql.models.Book;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class BooksRepository implements BaseRepository<Book> {
    private static final List<Book> books = new LinkedList<>();


    public List<Book> getAll() {
        return books;
    }

    public void add(Book item) {
        books.add(item);
    }

    public List<Book> search(String query) {
        return books.stream()
                .filter(b -> b.getAuthor().contains(query) || b.getTitle().contains(query))
                .collect(Collectors.toList());
    }

    @Override
    public Book getById(Long id) throws NotFoundResourceCustomException {
        return books.stream()
                .filter(b -> Objects.equals(b.getId(), id))
                .findFirst()
                .orElseThrow(() ->
                        new NotFoundResourceCustomException("There is no book with that ID")
                );
    }

    public Book getById(int id) throws NotFoundResourceCustomException {
        return books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new NotFoundResourceCustomException("There is no book with that ID")
                );
    }
}
