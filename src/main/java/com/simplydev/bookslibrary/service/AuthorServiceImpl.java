package com.simplydev.bookslibrary.service;

import com.simplydev.bookslibrary.entity.Author;
import com.simplydev.bookslibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> getAuthorByLastName(Author author, String lastName) {
        return authorRepository.findAuthorByLastName(lastName);
    }

    @Override
    public void addNewAuthor(Author author) {
        Optional<Author> authorOptional = authorRepository.findAuthorByLastName(author.getLastName());
        if(authorOptional.isPresent()){
            throw new IllegalStateException("Author already exist");
        }
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long authorId) {
        boolean exists = authorRepository.existsById(authorId);
        if (!exists){
            throw new IllegalStateException("Author with id " + authorId + "does not exist");
        }
        authorRepository.deleteById(authorId);
    }

    @Override
    public void updateAuthor(Long authorId,String firstName, String lastName) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalStateException(
                        "author with id " + authorId + " does not exist"));
        if (!Objects.equals(author.getLastName(), lastName) || !Objects.equals(author.getFirstName(), firstName)) {
            author.setLastName(lastName);
            author.setFirstName(firstName);
        }
    }

}
