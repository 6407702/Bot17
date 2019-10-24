package ru.hackathon.chatBot17.db.service;

import ru.hackathon.chatBot17.db.entity.Type;
import ru.hackathon.chatBot17.db.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service provides a functional interaction with Type table
 */
@Service
@Transactional
public class TypeService {

    private final TypeRepository repository;

    @Autowired
    public TypeService(TypeRepository repository) {
        this.repository = repository;
    }

    public Type save(Type command) {
        return repository.save(command);
    }

    public List<Type> findAll() {
        return repository.findAll();
    }

    public void remove(Type selectedType) {
        repository.delete(selectedType);
    }

    public void removeAll() {
        repository.deleteAll();
    }
}
