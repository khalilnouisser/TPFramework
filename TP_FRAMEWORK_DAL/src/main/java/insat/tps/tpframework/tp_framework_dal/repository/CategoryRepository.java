package insat.tps.tpframework.tp_framework_dal.repository;

import insat.tps.tpframework.tp_framework_dal.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,Long> {
    public Optional<Category> findByName(String name);
}
