package Godwin.WebApi.controllers;

import Godwin.WebApi.service.AuthorService;
import Godwin.WebApi.entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public Page<Author> getAuthors(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int size,
                                   @RequestParam(defaultValue = "id") String orderBy){
        return authorService.getAuthors(page, size, orderBy);
    }

    @GetMapping(value = "/{id}")
    public Author findById(@PathVariable int id){
        return authorService.findById(id);
    }

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
        authorService.findAuthorByIdAndDelete(id);
    }

}
