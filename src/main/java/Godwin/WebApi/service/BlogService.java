package Godwin.WebApi.service;

import entities.Blog;

import java.util.*;

public class BlogService {

    private final List<Blog> blogPost = new ArrayList<>();

    public List<Blog> getBlogPost(){
        return this.blogPost;
    }

    public int findPostById(int id){

        for (Blog blog: this.blogPost) {
            if (blog.getId() == id){
                return id;
            }else {
                System.err.println("not found");
            }
        }
        return id;
    }
    public Blog savePost(Blog blogBody){
        try {
            Random randomNum = new Random();
            blogBody.setId(randomNum.nextInt(1, 20));
            this.blogPost.add(blogBody);
            return blogBody;
        }catch (Exception ex){
            System.out.println("Not saved");
        }
        return blogBody;
    }





}
