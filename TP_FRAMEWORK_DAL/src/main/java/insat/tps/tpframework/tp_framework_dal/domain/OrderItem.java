package insat.tps.tpframework.tp_framework_dal.domain;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Book book;
    @ManyToOne
    private Order order;
    private int quantity;
    private Double promotion;

}
