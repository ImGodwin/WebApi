package entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Blog {
    private int id;
    private String categories;
    private String title;
    private String cover;
    private String content;
    private int readingTime;
}
