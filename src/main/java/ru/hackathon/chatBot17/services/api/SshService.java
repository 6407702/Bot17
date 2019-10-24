package ru.hackathon.chatBot17.services.api;

import java.io.IOException;

/**
 * Service provides operation with SSL connection
 */
public interface SshService {
    /**
     * Run a command and return a result.
     * @param serverIp address of the server
     * @param login login of technical user
     * @param pass password of technical user
     * @param command text of a command
     * @return result of the command or error text
     * */
    String runCommand(String serverIp, String login, String pass, String command) throws Exception;
}
