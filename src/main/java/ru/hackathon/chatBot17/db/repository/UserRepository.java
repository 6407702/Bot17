package ru.hackathon.chatBot17.db.repository;

import ru.hackathon.chatBot17.db.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.MANDATORY)
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();
    void deleteAll();
}
