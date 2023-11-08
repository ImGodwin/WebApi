package Godwin.WebApi.controllers;

import Godwin.WebApi.service.AuthorService;
import entities.Author;
import entities.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public List<Author> getAuthor(){
        return authorService.getAuthors();
    }

    @GetMapping("/{id}")
  /*  public Author findById(@PathVariable int id){
        return authorService.findAuthorById(id);
    }*/

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthorPost(@RequestBody Author body){
        return authorService.saveAuthor(body);
    }

    @PutMapping("/{id}")
    public Author findByIdAndUpdate(@PathVariable int id, @RequestBody Author body){
        return authorService.findAuthorByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable int id){
        authorService.findAuthorByByIdAndDelete(id);
    }

}
