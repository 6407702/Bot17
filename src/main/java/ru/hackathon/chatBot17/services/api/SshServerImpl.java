package ru.hackathon.chatBot17.services.api;

import org.springframework.stereotype.Service;

/**
 * Service provides operation with SSL connection
 */
@Service
public class SshServerImpl implements SshService {

    /**
     * @inheritDoc
     */
    @Override
    public String runCommand(String serverIp, String login, String pass, String command) {
        return "test";
    }
}
