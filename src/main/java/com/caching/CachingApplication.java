package com.caching;

import com.caching.entity.Book;
import com.caching.services.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.List;

@SpringBootApplication
@EnableCaching
public class CachingApplication implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(CachingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List.of(
                Book.builder().name("Book 1").category("Category 1").author("Author 1").publisher("Publisher 1").edition("1st").build(),
                Book.builder().name("Book 2").category("Category 2").author("Author 2").publisher("Publisher 2").edition("2st").build(),
                Book.builder().name("Book 3").category("Category 3").author("Author 3").publisher("Publisher 3").edition("3st").build(),
                Book.builder().name("Book 4").category("Category 4").author("Author 4").publisher("Publisher 4").edition("4st").build()
        ).forEach(bookService::addBook);
    }
}
