package Godwin.WebApi.controllers;

import Godwin.WebApi.service.BlogService;
import entities.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogposts")
public class BlogController {


    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public List<Blog> getBlog(){
        return blogService.getBlogPosts();
    }

    /*@GetMapping("/{id}")
    public Blog findById(@PathVariable int id){
        return blogService.findPostById(id);
    }*/

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Blog saveBlogPost(@RequestBody Blog body){
        return blogService.savePost(body);
    }

    @PutMapping("/{id}")
    public Blog findByIdAndUpdate(@PathVariable int id, @RequestBody Blog body){
        return blogService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable int id){
       blogService.findByBlogpostByIdAndDelete(id);
    }

}
