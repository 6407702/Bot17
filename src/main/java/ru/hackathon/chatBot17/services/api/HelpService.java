package ru.hackathon.chatBot17.services.api;

import ru.hackathon.chatBot17.common.ParsedCommand;

/**
 * Process help information
 * */
public interface HelpService {

    /**
     * Get help information
     * @param parsedCommand description of the command
     * @return text result of running
     * */
    String process(ParsedCommand parsedCommand) throws Exception;
}
