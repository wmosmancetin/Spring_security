package com.example.spring.Spring.Security.controller;

import com.example.spring.Spring.Security.entity.Book;
import com.example.spring.Spring.Security.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("user")
public class BookController {

    @Autowired
    private IBooksService booksService;

    @GetMapping("book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        Book book = booksService.getBookById(id);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @GetMapping("books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> list = booksService.getAllBooks();
        return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
    }

    @PostMapping("book")
    public ResponseEntity<Void> addBook(@RequestBody Book book, UriComponentsBuilder builder) {
        booksService.addBook(book);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/book/{id}").buildAndExpand(book.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
