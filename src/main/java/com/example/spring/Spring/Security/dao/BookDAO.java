package com.example.spring.Spring.Security.dao;

import com.example.spring.Spring.Security.entity.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class BookDAO implements IBookDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Book> getAllBooks() {
        String hql = "FROM Book";
        return (List<Book>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Book getBookById(long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public Book getBookByTitle(String title) {
        return entityManager.find(Book.class, title);
    }

    @Override
    public void addBook(Book book) {
        entityManager.persist(book);
    }

    @Override
    public void updateBook(Book book) {
        Book tempBook = getBookById(book.getId());
        tempBook.setTitle(book.getTitle());
        tempBook.setAuthor(book.getAuthor());
        tempBook.setGenre(book.getGenre());
        tempBook.setPublisher(book.getPublisher());
        entityManager.flush();
    }
}
