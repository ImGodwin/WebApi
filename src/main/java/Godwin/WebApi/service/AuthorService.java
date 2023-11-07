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

    private final List<Author> author = new ArrayList<>();

    public List<Author> getBlogPosts() {
        return this.author;
    }

    public int findPostById(int id){

         for (Author author1: this.author) {
             if (author1.getId() == id){
                 return author1.getId();
             }else {
                 System.err.println("not found");
             }
         }
         return id;
     }
    public Author savePost(Author authorPost){
        try {
            Random randomNum = new Random();
            authorPost.setId(randomNum.nextInt(1, 20));
            this.author.add(authorPost);
            return authorPost;
        }catch (Exception ex){
            System.out.println("Not saved");
        }
        return authorPost;
    }

    public Author findAuthorByIdAndUpdate(int id, Author author) {

        Author singleAuthor = null;
        try {
            for (Author author1 : this.author) {
                if (author1.getId() == id) {
                    singleAuthor = author1;
                    singleAuthor.setId(id);
                    singleAuthor.setName(author.getName());
                    singleAuthor.setSurname(author.getSurname());
                    singleAuthor.setEmail(author.getEmail());
                    singleAuthor.setDateOfBirth(author.getDateOfBirth());
                    singleAuthor.setAvatar(author.getAvatar());
                }
            }
        } catch (Exception ex) {
            System.err.println("not updated");
        }

        return singleAuthor;
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
