package Godwin.WebApi.service;

import Godwin.WebApi.Exceptions.BadRequestException;
import Godwin.WebApi.Exceptions.NotFoundException;
import Godwin.WebApi.entities.Blog;
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

    public Page<Blog> getBlogs(int page, int size, String orderBy){

        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return blogRepository.findAll(pageable);
    }

    public Blog findById(int id) throws NotFoundException {
        return blogRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Blog saveBlog(Blog body){

        blogRepository.findByTitle(body.getTitle()).ifPresent(blog1 -> {
            throw new BadRequestException("The blogpost " + blog1.getTitle() + " can no longer be added");
        });

        body.setCover("https://picsum.photos/200/300" + body.getTitle() +
                "and" + body.getContent());

        return blogRepository.save(body);
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
