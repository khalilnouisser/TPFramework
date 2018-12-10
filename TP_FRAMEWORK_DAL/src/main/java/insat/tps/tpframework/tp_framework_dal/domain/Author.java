package insat.tps.tpframework.tp_framework_dal.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToMany(mappedBy = "authorList")
    private List<Book> books;
}
