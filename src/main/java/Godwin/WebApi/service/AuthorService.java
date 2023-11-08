package Godwin.WebApi.service;

import Godwin.WebApi.Exceptions.BadRequestException;
import Godwin.WebApi.Exceptions.NotFoundException;
import Godwin.WebApi.entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import Godwin.WebApi.repositories.AuthorRepository;


@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Page<Author> getAuthors(int page, int size, String orderBy){

        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return authorRepository.findAll(pageable);
    }

    public Author findById(int id) throws NotFoundException{
        return authorRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Author saveAuthor(Author body){

        authorRepository.findByEmail(body.getEmail()).ifPresent(author1 -> {
            throw new BadRequestException("The email " + author1.getEmail() + " can no longer be added");
        });

        body.setAvatar("http://ui-avatars.com/api/?name=" + body.getName() +
                "and" + body.getSurname());

        return authorRepository.save(body);
    }

    public Author findAuthorByIdAndUpdate(int id, Author body){
        Author foundAuthor = this.findById(id);

        foundAuthor.setName(body.getName());
        foundAuthor.setSurname(body.getSurname());
        foundAuthor.setEmail(body.getEmail());
        return authorRepository.save(foundAuthor);
    }

    public void findAuthorByIdAndDelete(int id) throws NotFoundException {
        Author foundAuthor = this.findById(id);
        authorRepository.delete(foundAuthor);
    }
}
