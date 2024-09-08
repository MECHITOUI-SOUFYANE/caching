package com.caching.services.impl;

import com.caching.dao.BookRepository;
import com.caching.entity.Book;
import com.caching.services.api.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookServiveImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Override
    @Cacheable(cacheNames = "books" , condition = "#result == null" , keyGenerator = "customKeyGenerator")
    public Book findBookById(Integer id) {
        log.info("fetching data from database");
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book findBookByName(String name) {
        return bookRepository.findBookByName(name).orElse(null);
    }

    @Override
    @CachePut(cacheNames = "books" , key = "#book.id")
    public Book updateBook(Book book) {
        bookRepository.updateBook(book.getId(), book.getName());
        return book;
    }

    @Override
    @CacheEvict(cacheNames = "books" , key = "#id")
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
}
