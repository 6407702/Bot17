package ru.hackathon.chatBot17.services.security;

import org.springframework.stereotype.Service;

/**
 * Class provides security policy for checking commands
 */
@Service
public class SecurityChecksServiceImpl implements SecurityChecksService {

    /**
     * @inheritDoc
     */
    @Override
    public boolean checkSshCommand(String command) {
        //TODO: implement security rules for ssh commands.
        return true;
    }
}
