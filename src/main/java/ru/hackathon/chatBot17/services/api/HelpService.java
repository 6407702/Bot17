package ru.hackathon.chatBot17.services.api;

import ru.hackathon.chatBot17.common.ParsedCommand;

public interface HelpService {

    String process(ParsedCommand parsedCommand) throws Exception;
}
