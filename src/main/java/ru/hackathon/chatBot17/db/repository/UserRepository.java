package ru.hackathon.chatBot17.db.repository;

import ru.hackathon.chatBot17.db.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Interface defining a methods of functional interaction with User table
 */
@Transactional(propagation = Propagation.MANDATORY)
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    void deleteAll();

    User getByName(String name);
}
