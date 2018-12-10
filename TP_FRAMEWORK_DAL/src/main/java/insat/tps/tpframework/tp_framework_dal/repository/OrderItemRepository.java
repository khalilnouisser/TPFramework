package insat.tps.tpframework.tp_framework_dal.repository;

import insat.tps.tpframework.tp_framework_dal.domain.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItem,Long> {
}
