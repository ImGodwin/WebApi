package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Blog {
    private int id;
    private String categories;
    private String title;
    private String cover;
    private String content;
    private int readingTime;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
}
