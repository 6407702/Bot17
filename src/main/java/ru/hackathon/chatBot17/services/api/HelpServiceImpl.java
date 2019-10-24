package ru.hackathon.chatBot17.services.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hackathon.chatBot17.common.ParsedCommand;
import ru.hackathon.chatBot17.db.entity.Command;
import ru.hackathon.chatBot17.db.service.CommandService;

import java.util.List;

/**
 * Implementation for Processing a help information
 * */
@Service
public class HelpServiceImpl implements HelpService {

    @Autowired
    CommandService commandService;

    /**
     * @inheritDoc
     */
    @Override
    public String process(ParsedCommand parsedCommand) throws Exception {
        StringBuilder sb = new StringBuilder();
        List<Command> list = commandService.findAll();
        for (Command command : list) {
            sb.append(command.getCommands() + " - " + command.getDescription() + "\n\r");
        }
        return sb.toString();
    }
}
