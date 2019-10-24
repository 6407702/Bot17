package ru.hackathon.chatBot17.db.repository;

import ru.hackathon.chatBot17.db.entity.Command;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Interface defining a methods of functional interaction with Command table
 */
@Transactional(propagation = Propagation.MANDATORY)
public interface CommandRepository extends CrudRepository<Command, Long> {

    List<Command> findAll();
    void deleteAll();
}
