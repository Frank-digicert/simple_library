package org.example.service;

import org.example.entity.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("bookService")
public class BookServiceImpl implements BookService{
    // To do: use a database to store book data, I do not have permission to install an app from a third party (i.e. mySQL)
    static Map<Long, Book> map = Collections.synchronizedMap(new HashMap<>());
    @Override
    public List<Book> listAllBooks() {
        List<Book> bookList = new ArrayList<>(map.values());
        return bookList;
    }

    @Override
    public Book getBook(long id) {
        return map.get(id);
    }

    @Override
    public String postBook(Book book) {
        map.put(book.getId(), book);
        if (!map.isEmpty()) {
            return "Successfully added a book!";
        }
        return "Failed to add a book";
    }

    @Override
    public String putBook(long id, Book book) {
        Book currentBook = map.get(id);
        currentBook.setName(book.getName());
        currentBook.setAuthor(book.getAuthor());
        map.put(id, currentBook);
        return "Successfully update a book!";
    }

    @Override
    public String deleteBook(long id) {
        map.remove(id);
        return "Successfully remove a book!";
    }
}
