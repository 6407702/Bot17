package ru.hackathon.chatBot17.services.security;

import org.springframework.stereotype.Service;

/**
 * Class provides security policy for checking commands
 */
@Service
public class SecurityChecksImpl implements SecurityChecks {

    /**
     * @inheritDoc
     */
    @Override
    public boolean checkSshCommand(String command) {
        //TODO: implement security rules for ssh commands.
        return true;
    }
}
