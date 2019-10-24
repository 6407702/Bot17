package db.service;

import db.entity.Command;
import db.repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommandService {

    private final CommandRepository repository;

    @Autowired
    public CommandService(CommandRepository repository) {
        this.repository = repository;
    }

    public Command save(Command command) {
        return repository.save(command);
    }

    public List<Command> findAll() {
        return repository.findAll();
    }

    public void remove(Command selectedCommand) {
        repository.delete(selectedCommand);
    }
}
