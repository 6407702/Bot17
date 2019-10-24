package ru.hackathon.chatBot17.db.service;

import ru.hackathon.chatBot17.db.entity.User;
import ru.hackathon.chatBot17.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User save(User command) {
        return repository.save(command);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public void remove(User selectedUser) {
        repository.delete(selectedUser);
    }
}
