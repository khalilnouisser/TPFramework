package insat.tps.tpframework.tp_framework_dal.domain;

import insat.tps.tpframework.tp_framework_dal.domain.dto.AuthorDTO;
import insat.tps.tpframework.tp_framework_dal.domain.dto.BookDTO;
import insat.tps.tpframework.tp_framework_dal.domain.dto.CategoryDTO;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private int yearPublished;
    private String ISBN;
    private Double price;
    private int edition;
    private Double priceAfterPromotion;
    @ManyToMany
    private List<Author> authorList;
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "book")
    private List<OrderItem> orderItems;

    public BookDTO adapt(ModelMapper modelMapper) {
        BookDTO book = modelMapper.map(this, BookDTO.class);
        if (this.getCategory() != null){
            book.setCategory(modelMapper.map(this.getCategory(), CategoryDTO.class));
        }
        List<AuthorDTO> listAuthors = this.getAuthorList().stream().map(x -> modelMapper.map(x, AuthorDTO.class)).collect(Collectors.toList());
        book.setAuthorList(listAuthors);
        return book;
    }

}
