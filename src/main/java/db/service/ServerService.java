package db.service;

import db.entity.Server;
import db.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServerService {

    private final ServerRepository repository;

    @Autowired
    public ServerService(ServerRepository repository) {
        this.repository = repository;
    }

    public Server save(Server server) {
        return repository.save(server);
    }

    public List<Server> findAll() {
        return repository.findAll();
    }

    public void remove(Server selectedServer) {
        repository.delete(selectedServer);
    }
}
