package db.service;

import db.entity.UserServerLink;
import db.repository.UserServerLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServerLinkService {

    private final UserServerLinkRepository repository;

    @Autowired
    public UserServerLinkService(UserServerLinkRepository repository) {
        this.repository = repository;
    }

    public UserServerLink save(UserServerLink command) {
        return repository.save(command);
    }

    public List<UserServerLink> findAll() {
        return repository.findAll();
    }

    public void remove(UserServerLink selectedUserServerLink) {
        repository.delete(selectedUserServerLink);
    }
}
