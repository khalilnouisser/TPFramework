package insat.tps.tpframework.tp_framework_dal.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Order {
    @Id
    private Long id;
    private Double salesTaxes;
    private Double shipingFee;
    private Double total;
    @ManyToOne
    private Customer user;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
}
