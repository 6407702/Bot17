package ru.hackathon.chatBot17.db.repository;

import ru.hackathon.chatBot17.db.entity.Server;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Interface defining a methods of functional interaction with Server table
 */
@Transactional(propagation = Propagation.MANDATORY)
public interface ServerRepository extends CrudRepository<Server, Long> {

    List<Server> findAll();

    Server findByCode(String code);

    void deleteAll();
}
