package ru.hackathon.chatBot17.db.service;

import ru.hackathon.chatBot17.db.entity.Command;
import ru.hackathon.chatBot17.db.repository.CommandRepository;
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

    public void removeAll() {
        repository.deleteAll();
    }
}
