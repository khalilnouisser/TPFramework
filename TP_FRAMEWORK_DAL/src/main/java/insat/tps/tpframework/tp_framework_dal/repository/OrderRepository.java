package insat.tps.tpframework.tp_framework_dal.repository;

import insat.tps.tpframework.tp_framework_dal.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Long> {
}
