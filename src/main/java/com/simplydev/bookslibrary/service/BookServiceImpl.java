package com.simplydev.bookslibrary.service;

import com.simplydev.bookslibrary.entity.Book;
import com.simplydev.bookslibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookByTitle(Book book, String title) {
        return bookRepository.findBookByTitle(title);
    }

    @Override
    public void addNewBook(Book book) {
        Optional<Book> bookOptional = bookRepository.findBookByTitle(book.getTitle());
        if(bookOptional.isPresent()){
            throw new IllegalStateException("Book already exist");
        }
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if (!exists){
            throw new IllegalStateException("Book with id " + bookId + " does not exist");
        }
        bookRepository.deleteById(bookId);
    }

    @Override
    @Transactional
    public void updateBook(Long bookId, String title) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalStateException(
                        "book with id " + bookId + " does not exist"));
        if (!Objects.equals(book.getTitle(), title)) {
            book.setTitle(title);
            bookRepository.saveAndFlush(book);
        }

    }

}
