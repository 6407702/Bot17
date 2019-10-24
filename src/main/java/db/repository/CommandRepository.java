package db.repository;

import db.entity.Command;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.MANDATORY)
public interface CommandRepository extends CrudRepository<Command, Long> {

    List<Command> findAll();
}
