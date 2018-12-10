package insat.tps.tpframework.tp_framework_dal.domain;



import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Customer extends User {
    @OneToOne
    private Adresse shipingAdresse;
    @OneToMany(mappedBy = "user")
    private List<Order> orderList;


}
