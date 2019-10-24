package db.repository;

import db.entity.TechUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.MANDATORY)
public interface TechUserRepository extends CrudRepository<TechUser, Long> {

    List<TechUser> findAll();
}
