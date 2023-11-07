package Godwin.WebApi.service;

import entities.Blog;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class BlogService {

    private final List<Blog> blogPost = new ArrayList<>();

    public List<Blog> getBlogPosts() {
        return this.blogPost;
    }

   /* public int findPostById(int id){

        for (Blog blog: this.blogPost) {
            if (blog.getId() == id){
                return blog.getId();
            }else {
                System.err.println("not found");
            }
        }
        return id;
    }*/
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

    public Blog findByIdAndUpdate(int id, Blog blogBody) {

        Blog singleBlogPost = null;
        try {
            for (Blog blog : this.blogPost) {
                if (blog.getId() == id) {
                    singleBlogPost = blog;
                    singleBlogPost.setId(id);
                    singleBlogPost.setCategories(blogBody.getCategories());
                    singleBlogPost.setTitle(blogBody.getTitle());
                    singleBlogPost.setCover(blog.getCover());
                    singleBlogPost.setContent(blog.getContent());
                    singleBlogPost.setReadingTime(blog.getReadingTime());
                }
            }
        } catch (Exception ex) {
            System.err.println("not updated");
        }

        return singleBlogPost;
    }

    public void findByBlogpostByIdAndDelete(int id){

        try {
            ListIterator<Blog> iterateBlogPosts = this.blogPost.listIterator();

            while (iterateBlogPosts.hasNext()){
                Blog currentPosition = iterateBlogPosts.next();
                if (currentPosition.getId() == id){
                    iterateBlogPosts.remove();
                }
            }
        }catch (Exception ex){
            System.err.println("Blogpost not deleted");
        }

    }








}
