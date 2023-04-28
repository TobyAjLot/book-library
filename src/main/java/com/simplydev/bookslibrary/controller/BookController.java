package com.simplydev.bookslibrary.controller;

import com.simplydev.bookslibrary.entity.Book;
import com.simplydev.bookslibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/booklibrary")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> bookList(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{title}")
    public Optional<Book> getBookByTitle(@RequestBody Book book, @PathVariable("title") String title){
        return bookService.getBookByTitle(book, title);
    }

    @PostMapping("/add_book")
    public void addNewBook(@RequestBody Book book){
        bookService.addNewBook(book);
    }

    @DeleteMapping("/delete/{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId){
        bookService.deleteBook(bookId);
    }

    @PutMapping("/edit/{bookId}")
    public void editBook(
            @PathVariable("bookId") Long bookId,
            @RequestBody String title
    ){
        bookService.updateBook(bookId, title);
    }

}
