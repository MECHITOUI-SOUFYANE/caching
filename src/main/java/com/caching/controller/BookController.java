package com.caching.controller;

import com.caching.entity.Book;
import com.caching.services.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(bookService.findBookById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Integer id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatusCode.valueOf(HttpStatus.NO_CONTENT.value()));
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.updateBook(book));
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.addBook(book));
    }
}
