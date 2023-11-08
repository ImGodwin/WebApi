package Godwin.WebApi.controllers;

import Godwin.WebApi.service.BlogService;
import Godwin.WebApi.entities.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogposts")
public class BlogController {


    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public Page<Blog> getBlogs(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int size,
                                   @RequestParam(defaultValue = "id") String orderBy){
        return blogService.getBlogs(page, size, orderBy);
    }

    @GetMapping(value = "/{id}")
    public Blog findById(@PathVariable int id){
        return blogService.findById(id);
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Blog saveBlogPost(@RequestBody Blog body){
        return blogService.saveBlog(body);
    }

    @PutMapping("/{id}")
    public Blog findByIdAndUpdate(@PathVariable int id, @RequestBody Blog body){
        return blogService.findBlogByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable int id){
        blogService.findBlogByIdAndDelete(id);
    }

}
