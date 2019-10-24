package db.service;

import db.entity.TechUser;
import db.repository.TechUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public void remove(TechUser selectedTechUser) {
        repository.delete(selectedTechUser);
    }
}
