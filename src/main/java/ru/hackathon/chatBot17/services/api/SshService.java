package ru.hackathon.chatBot17.services.api;

import ru.hackathon.chatBot17.common.ParsedCommand;

import java.io.IOException;

/**
 * Service provides operation with SSL connection
 */
public interface SshService {

    /**
     * Get result of the running a command
     * @param parsedCommand description of the command
     * @return text result of running
     * */
    String process(ParsedCommand parsedCommand) throws Exception;
}
