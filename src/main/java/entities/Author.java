package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Author {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String dateOfBirth;
    private String avatar;

    @OneToMany(mappedBy = "Author")
    private List<Blog> blogList;

}
