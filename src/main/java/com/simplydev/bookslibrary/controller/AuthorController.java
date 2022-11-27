package com.simplydev.bookslibrary.controller;

import com.simplydev.bookslibrary.entity.Author;
import com.simplydev.bookslibrary.entity.Category;
import com.simplydev.bookslibrary.service.AuthorService;
import com.simplydev.bookslibrary.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/booklibrary")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public List<Author> authorList(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/{lastName}")
    public Optional<Author> getAuthorByLastName(@RequestBody Author author, @PathVariable("lastName") String lastName){
        return authorService.getAuthorByLastName(author, lastName);
    }

    @PostMapping("/add_author")
    public void addNewAuthor(@RequestBody Author author){
        authorService.addNewAuthor(author);
    }

    @DeleteMapping("/delete/{authorId}")
    public void deleteAuthor(@PathVariable("authorId") Long authorId){
        authorService.deleteAuthor(authorId);
    }

    @PutMapping("/edit/{authorId}")
    public void editAuthor(
            @PathVariable("authorId") Long authorId,
            @RequestParam(required = false) String firstName, String lastName
    ){
        authorService.updateAuthor(authorId, firstName, lastName);
    }
}
