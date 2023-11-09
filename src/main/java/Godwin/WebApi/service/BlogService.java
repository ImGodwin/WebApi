package Godwin.WebApi.service;

import Godwin.WebApi.Exceptions.BadRequestException;
import Godwin.WebApi.Exceptions.NotFoundException;
import Godwin.WebApi.entities.Blog;
import Godwin.WebApi.entities.NewPost;
import Godwin.WebApi.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import Godwin.WebApi.repositories.BlogRepository;


@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private AuthorService authorService;

    public Page<Blog> getBlogs(int page, int size, String orderBy){

        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return blogRepository.findAll(pageable);
    }

    public Blog findById(int id) throws NotFoundException {
        return blogRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Blog saveBlog(NewPost newPost){

        Blog newBlogPost = new Blog();
        newBlogPost.setCategories(newPost.getCategories());
        newBlogPost.setContent(newPost.getContent());
        newBlogPost.setTitle(newPost.getTitle());
        newBlogPost.setAuthor(authorService.findById(newPost.getAuthor_id()));
        newBlogPost.setCover("https://picsum.photos/200/300");


        return blogRepository.save(newBlogPost);
    }

    public Blog findBlogByIdAndUpdate(int id, Blog body){
        Blog foundBlog = this.findById(id);

        foundBlog.setCategories(body.getCategories());
        foundBlog.setTitle(body.getTitle());
        foundBlog.setContent(body.getContent());
        return blogRepository.save(foundBlog);
    }

    public void findBlogByIdAndDelete(int id) throws NotFoundException {
        Blog foundBlog = this.findById(id);
        blogRepository.delete(foundBlog);
    }
}
