package org.example.controller;

import org.example.entity.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/listAll")
    public List<Book> listAllBooks() {
        return bookService.listAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable long id) {
        return bookService.getBook(id);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable long id) {
        return bookService.deleteBook(id);
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable long id, Book book) {
        return bookService.putBook(id, book);
    }

    @PostMapping("/")
    public String addBook(@RequestBody Book book) {
        return bookService.postBook(book);
    }
}
