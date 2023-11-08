package Godwin.WebApi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String categories;
    private String title;
    private String cover;
    private String content;
    private int readingTime;
    @CreationTimestamp
    private Date CreatedAt;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
}
