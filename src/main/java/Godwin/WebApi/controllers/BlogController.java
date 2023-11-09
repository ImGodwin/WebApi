package Godwin.WebApi.controllers;

import Godwin.WebApi.Exceptions.BadRequestException;
import Godwin.WebApi.entities.NewPost;
import Godwin.WebApi.payloadPackage.NewblogPostDTO;
import Godwin.WebApi.service.BlogService;
import Godwin.WebApi.entities.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Blog saveBlogPost(@RequestBody @Validated NewblogPostDTO newPost, BindingResult validation){

        if (validation.hasErrors()){
            throw new BadRequestException(validation.getAllErrors());
        }else {
            return blogService.saveBlog(newPost);
        }

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

    @PostMapping("/uploadPhoto")
    public String uploadExample(@RequestParam("avatar") MultipartFile body) throws IOException {
        System.out.println(body.getSize());
        System.out.println(body.getContentType());
        return blogService.uploadPicture(body);
    }
}
