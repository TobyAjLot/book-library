package com.simplydev.bookslibrary.service;

import com.simplydev.bookslibrary.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> getAllAuthors();

    void addNewAuthor(Author author);

    void deleteAuthor(Long authorId);

    Optional<Author> getAuthorByLastName(Author author, String lastName);

    void updateAuthor(Long authorId, String firstName, String lastName);
}
