package ru.hackathon.chatBot17.db.repository;

import ru.hackathon.chatBot17.db.entity.TechUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Interface defining a methods of functional interaction with TechUser table
 */
@Transactional(propagation = Propagation.MANDATORY)
public interface TechUserRepository extends CrudRepository<TechUser, Long> {

    List<TechUser> findAll();
    void deleteAll();
}
