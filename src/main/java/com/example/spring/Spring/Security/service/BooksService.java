package com.example.spring.Spring.Security.service;

import com.example.spring.Spring.Security.dao.IBookDAO;
import com.example.spring.Spring.Security.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService implements IBooksService {
    @Autowired
    private IBookDAO bookDAO;


    @Override
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookDAO.getBookByTitle(title);
    }

    @Override
    public Book getBookById(Long id) {
        return bookDAO.getBookById(id);
    }

    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }
}
