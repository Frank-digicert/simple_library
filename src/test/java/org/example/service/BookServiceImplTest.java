package org.example.service;

import org.example.entity.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class BookServiceImplTest {
    private Book bookOne, bookTwo;
    private BookService bookService;
    @Before
    public void setUp() {
        bookOne = new Book(1L, "bookOne", "Alex");
        bookTwo = new Book(2L, "bookTwo", "David");
        this.bookService = new BookServiceImpl();
        bookService.postBook(bookOne);
        bookService.postBook(bookTwo);
    }
    @Test
    public void listAllBooks() {
        List<Book> bookList = bookService.listAllBooks();
        List<Long> idList = new ArrayList<>();
        for (Book book : bookList) {
            idList.add(book.getId());
        }
        assertTrue(idList.contains(1L));
        assertTrue(idList.contains(2L));
    }

    @Test
    public void getBook() {
        Book book = bookService.getBook(1L);
        assertEquals(book.getName(), "bookOne");
        assertEquals(book.getAuthor(), "Alex");
    }

    @Test
    public void postBook() {
        Book bookThree = new Book(3L, "bookThree", "Frank");
        bookService.postBook(bookThree);
        assertNotNull(bookService.getBook(3L));
    }

    @Test
    public void putBook() {
        Book book = new Book(2L, "bookTwo", "Jim");
        bookService.putBook(2L, book);
        assertEquals(bookService.getBook(2L).getAuthor(), "Jim");
    }

    @Test
    public void deleteBook() {
        bookService.deleteBook(3L);
        assertNull(bookService.getBook(3L));
    }
}