package com.simplydev.bookslibrary.repository;

import com.simplydev.bookslibrary.entity.Author;
import com.simplydev.bookslibrary.entity.Book;
import com.simplydev.bookslibrary.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.Collections;


@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void addBook(){

        Collection<Category> category = Collections.singleton(Category.builder()
                .id(1l)
                .name("Fantasy")
                .build());

        Collection<Author> author = Collections.singleton(Author.builder()
                .id(1l)
                .firstName("JK")
                .lastName("Rowling")
                .build());

        Book book = Book.builder()
                .id(9l)
                .title("Harry Potter and the Philosopher's Stone")
                .categories(category)
                .authors(author)
                .build();

        bookRepository.save(book);
    }
}