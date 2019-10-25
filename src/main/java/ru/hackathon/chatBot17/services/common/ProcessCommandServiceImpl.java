package ru.hackathon.chatBot17.services.common;

import com.google.rpc.Help;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hackathon.chatBot17.common.CommandTypes;
import ru.hackathon.chatBot17.common.ParsedCommand;
import ru.hackathon.chatBot17.db.entity.Command;
import ru.hackathon.chatBot17.db.entity.User;
import ru.hackathon.chatBot17.services.api.JenkinsService;
import ru.hackathon.chatBot17.services.api.SshService;
import ru.hackathon.chatBot17.services.api.HelpService;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parse and get result of the command
 */
@Service
public class ProcessCommandServiceImpl implements ProcessCommandService {

    @Autowired
    SshService sshService;

    @Autowired
    JenkinsService jenkinsService;
    @Autowired
    HelpService helpService;

    /**
     * @inheritDoc
     * */
    @Override
    public String processCommand(String command, User user) throws Exception {
        ParsedCommand parsedCommand = parseMessage(command);
        switch (parsedCommand.getType()) {
            case SSH: {
                return sshService.process(parsedCommand, user);
            }
            case JNK: {
                return jenkinsService.process(parsedCommand);
            }
            case HELP: {
                return helpService.process(parsedCommand);
            }
            case GIT: {
                return "Processing GIT commands will be implemented later. Sorry for inconvenience.";
            }

        }
        return "incorrect command";
    }

    /**
     * Get parsed user command
     * //TODO: fix parsing!
     **/
    private ParsedCommand parseMessage(String msg) {
        ParsedCommand parsedCommand = new ParsedCommand();
        Pattern p = Pattern.compile("[a-zA-Z0-9]+");
        Matcher m1 = p.matcher(msg);
        //type
        if (m1.find()) {
            CommandTypes type = CommandTypes.getTypeByName(m1.group());
            parsedCommand.setType(type);
        }
        //command
        if (m1.find()) {
            parsedCommand.setCommand(m1.group());
        }
        //arg
        if (m1.find()) {
            parsedCommand.setArgument(m1.group());
        }
        return parsedCommand;
    }
}
