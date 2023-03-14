package controllers;

import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pojo.Book;
import pojo.BookInput;
import repositories.BookRepository;
import repositories.CategoryRepository;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/book")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

   @GetMapping("/book/{category}")
    public List<Book> getByCategory(@PathVariable Category category) {
        return bookRepository.findByCategory(category);
    }

    @GetMapping("/book/{id}")
    public Book findNote(@PathVariable Integer id) {
        return bookRepository.findBookById(id);
    }
    @PostMapping("/book")
    public Book createBook(@RequestBody BookInput bookInput){
        String newTitle=bookInput.getTitle();
        String newAuthor=bookInput.getAuthor();
        String newPublisher=bookInput.getPublisher();

        Book book = new Book();
        book.setTitle(newTitle);
        book.setAuthor(newAuthor);
        book.setPublisher(newPublisher);

        return bookRepository.save(book);
    }

    @DeleteMapping("/book/{id}")
    public boolean deleteBook(@PathVariable Integer id) {
        Book book = bookRepository.findBookById(id);
        if (book != null) {
            bookRepository.delete(book);
        }
        return true;
    }

}