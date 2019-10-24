package ru.hackathon.chatBot17.services.security;

/**
 * Service provides security policy for checking commands
 */
public interface SecurityChecks {

    /**
     * Check ssh command for injections, etc
     * @param command
     * @return true - ok, false - stop processing
     */
    boolean checkSshCommand(String command);
}
