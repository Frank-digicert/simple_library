package org.example.service;

import org.example.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> listAllBooks();
    public Book getBook(long id);
    public String postBook(Book book);
    public String putBook(long id, Book book);
    public String deleteBook(long id);
}
