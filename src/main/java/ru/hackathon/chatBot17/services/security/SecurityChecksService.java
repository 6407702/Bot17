package ru.hackathon.chatBot17.services.security;

import ru.hackathon.chatBot17.db.entity.User;

/**
 * Service provides security policy for checking commands
 */
public interface SecurityChecksService {

    /**
     * Check ssh command for injections, etc
     * @param command
     * @return true - ok, false - stop processing
     */
    boolean checkSshCommandInjection(String command);

    /**
     * Check user privilege for launching the command
     * @param user who posted a command
     * @param command
     * @return true - ok, false - stop processing
     */
    boolean checkSshCommandUserRights(User user, String command);

    /**
     * Check jenkings command
     * @param command
     * @return true - ok, false - stop processing
     */
    boolean checkJenkinsCommand(String command);
}
