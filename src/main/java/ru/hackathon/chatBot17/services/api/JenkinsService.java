package ru.hackathon.chatBot17.services.api;

import ru.hackathon.chatBot17.common.ParsedCommand;

import java.net.URI;

public interface JenkinsService {
    /**
     * Run a command and return a result.
     * @return result of the command or error text
     * */
    String process(ParsedCommand parsedCommand) throws Exception;
}
