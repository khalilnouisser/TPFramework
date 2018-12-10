package insat.tps.tpframework.tp_framework_dal.repository;

import insat.tps.tpframework.tp_framework_dal.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository<T extends User> extends CrudRepository<T,Long> {
    T findByEmail(String email);
    T findByEmailAndPassword(String email, String password);
}