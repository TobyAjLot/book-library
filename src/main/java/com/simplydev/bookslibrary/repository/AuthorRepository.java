package com.simplydev.bookslibrary.repository;

import com.simplydev.bookslibrary.entity.Author;
import com.simplydev.bookslibrary.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findAuthorByLastName(String lastName);

}
