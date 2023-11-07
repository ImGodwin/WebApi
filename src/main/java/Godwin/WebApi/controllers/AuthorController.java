package Godwin.WebApi.controllers;

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


    @GetMapping("")
    public List<Author> getAuthor(){
        return null;
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable int id){
        return null;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthorPost(@RequestBody Author body){
        return null;
    }

    @PutMapping("/{id}")
    public Author findByIdAndUpdate(@PathVariable int id, @RequestBody Author body){
        return null;
    }

    /*@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable int id){
        return null;
    }*/

}
