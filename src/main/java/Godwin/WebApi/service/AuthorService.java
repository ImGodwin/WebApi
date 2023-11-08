package Godwin.WebApi.service;

import entities.Author;
import entities.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

@Service
public class AuthorService {

    private List<Author> author = new ArrayList<>();

    public List<Author> getAuthors() {
        return this.author;
    }

    public Author findAuthorById(int id){

         for (Author author1: this.author) {
             if (author1.getId() == id){
                 return author1;
             }
         }
         throw new RuntimeException("not found");
     }

    public Author saveAuthor(Author body){
        try {
            Random randomNum = new Random();
            body.setId(randomNum.nextInt(1, 20));
            this.author.add(body);
            return body;
        }catch (Exception ex){
            System.out.println("Not saved");
        }
        return body;
    }

    public Author findAuthorByIdAndUpdate(int id, Author author) {

        Author singleAuthor = null;

            for (Author author1 : this.author) {
                if (author1.getId() == id) {
                    singleAuthor = author1;
                    singleAuthor.setId(id);
                    singleAuthor.setName(author.getName());
                    singleAuthor.setSurname(author.getSurname());
                    singleAuthor.setEmail(author.getEmail());
                    singleAuthor.setDateOfBirth(author.getDateOfBirth());
                    singleAuthor.setAvatar(author.getAvatar());
                    return singleAuthor;
                }
            }
        throw new RuntimeException("not found");
    }

    public void findAuthorByByIdAndDelete(int id){

        try {
            ListIterator<Author> iterateAuthorList = this.author.listIterator();

            while (iterateAuthorList.hasNext()){
                Author currentPosition = iterateAuthorList.next();
                if (currentPosition.getId() == id){
                    iterateAuthorList.remove();
                }
            }
        }catch (Exception ex){
            System.err.println("Blogpost not deleted");
        }

    }

}
