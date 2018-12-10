package insat.tps.tpframework.tp_framework_dal.domain.dto;
import lombok.Data;
import java.util.List;

@Data
public class BookDTO {
    private Long id;
    private String title;
    private int yearPublished;
    private String ISBN;
    private Double price;
    private int edition;
    private Double priceAfterPromotion;
    private List<AuthorDTO> authorList;
    private CategoryDTO category;

}
