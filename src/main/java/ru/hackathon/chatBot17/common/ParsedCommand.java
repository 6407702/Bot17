package ru.hackathon.chatBot17.common;

import java.util.List;


/**
 * DTO command and its arguments
 */
public class ParsedCommand {

    private CommandTypes type;

    private String command;

    private String argument;

    public CommandTypes getType() {
        return type;
    }

    public void setType(CommandTypes type) {
        this.type = type;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }


}
