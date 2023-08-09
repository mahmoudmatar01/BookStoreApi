package com.api.BooksApiWithMySql.interfaces;


import com.api.BooksApiWithMySql.exceptions.NotFoundBookCustomException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseRepository<T> {
    List<T> getAll();

    void add(T item);

    List<T> search(String query);

    T getById(Long id) throws NotFoundBookCustomException;
}
