package db.repository;

import db.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.MANDATORY)
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();
}
