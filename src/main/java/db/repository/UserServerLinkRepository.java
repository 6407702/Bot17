package db.repository;

import db.entity.UserServerLink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.MANDATORY)
public interface UserServerLinkRepository extends CrudRepository<UserServerLink, Long> {

    List<UserServerLink> findAll();
}
