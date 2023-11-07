package Godwin.WebApi.service;

import entities.Blog;

import java.util.*;

public class BlogService {

    private final List<Blog> blogPost = new ArrayList<>();

    public Blog savePost(Blog blogBody){
        Blog toSave = blogBody;
        try {
            Random randomNum = new Random();
            blogBody.setId(randomNum.nextInt(1, 20));
            this.blogPost.add(blogBody);
            return toSave;
        }catch (Exception ex){
            System.out.println("Not saved");
        }
        return  toSave;
    }

    public Blog findPostById(int id){
        Blog
    }

}
