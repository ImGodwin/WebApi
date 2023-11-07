package Godwin.WebApi.controllers;

import Godwin.WebApi.service.BlogService;
import entities.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/blogposts")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public Set<Blog> getBlog(){
        return null;
    }

    @GetMapping("/{id}")
    public Blog findById(@PathVariable int id){
        return null;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Blog saveBlogPost(@RequestBody Blog body){
        return null;
    }

    @PutMapping("/{id}")
    public Blog findByIdAndUpdate(@PathVariable int id, @RequestBody Blog body){
        return null;
    }

    /*@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable int id){
        return null;
    }*/

}
