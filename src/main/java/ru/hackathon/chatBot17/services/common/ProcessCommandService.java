package ru.hackathon.chatBot17.services.common;

/**
 * Parse and get result of the command
 * */
public interface ProcessCommandService {

    /**
     * Process in several services based on the command type.
     * */
    String processCommand(String command) throws Exception;
}
