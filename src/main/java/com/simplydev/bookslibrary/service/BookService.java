package com.simplydev.bookslibrary.service;

import com.simplydev.bookslibrary.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAllBooks();

    void addNewBook(Book book);

    Optional<Book> getBookByTitle(Book book, String title);

    void deleteBook(Long bookId);

    void updateBook(Long bookId, String title);
}
