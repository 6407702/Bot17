package ru.hackathon.chatBot17.db.service;

import ru.hackathon.chatBot17.db.entity.TechUser;
import ru.hackathon.chatBot17.db.repository.TechUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service provides a functional interaction with TechUser table
 */
@Service
@Transactional
public class TechUserService {

    private final TechUserRepository repository;

    @Autowired
    public TechUserService(TechUserRepository repository) {
        this.repository = repository;
    }

    public TechUser save(TechUser command) {
        return repository.save(command);
    }

    public List<TechUser> findAll() {
        return repository.findAll();
    }

    public String find(long id) {
        return String.valueOf(repository.findById(id));
    }

    public void remove(TechUser selectedTechUser) {
        repository.delete(selectedTechUser);
    }

    public void removeAll() {
        repository.deleteAll();
    }
}
