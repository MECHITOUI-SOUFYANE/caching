package com.caching.services.api;

import com.caching.entity.Book;

public interface BookService {
    Book findBookById(Integer id);
    Book findBookByName(String name);
    Book updateBook(Book book);
    void deleteBook(Integer id);

    Book addBook(Book book);
}
