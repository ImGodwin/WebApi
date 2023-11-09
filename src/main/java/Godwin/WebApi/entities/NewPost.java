package Godwin.WebApi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewPost {
    private String categories;
    private String title;
    private String cover;
    private String content;
    private int readingTime;
    private int author_id;
}
