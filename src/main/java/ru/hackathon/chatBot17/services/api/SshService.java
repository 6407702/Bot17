package ru.hackathon.chatBot17.services.api;

import ru.hackathon.chatBot17.common.ParsedCommand;
import ru.hackathon.chatBot17.db.entity.User;

/**
 * Service provides operation with SSL connection
 */
public interface SshService {

    /**
     * Get result of the running a command
     * @param parsedCommand description of the command
     * @param user
     * @return text result of running
     * */
    String process(ParsedCommand parsedCommand, User user) throws Exception;
}
