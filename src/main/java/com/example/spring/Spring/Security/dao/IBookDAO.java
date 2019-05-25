package com.example.spring.Spring.Security.dao;

import com.example.spring.Spring.Security.entity.Book;

import java.util.List;

public interface IBookDAO {

    List<Book> getAllBooks();

    Book getBookById(long id);

    Book getBookByTitle(String title);

    void addBook(Book book);

    void updateBook(Book book);
}
