package ru.hackathon.chatBot17.services.common;

import ru.hackathon.chatBot17.db.entity.User;

/**
 * Parse and get result of the command
 * */
public interface ProcessCommandService {

    /**
     * Process in several services based on the command type.
     * */
    String processCommand(String command, User user) throws Exception;
}
