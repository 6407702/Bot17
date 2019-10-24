package ru.hackathon.chatBot17.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "Command")
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long command_id;

    @Column(name = "commands", nullable = false)
    private String commands;

    @Column(name = "text")
    private String text;

    @Column(name = "type", nullable = false)
    private int type;

    public Command(String commands, String text, int type) {
        this.commands = commands;
        this.text = text;
        this.type = type;
    }

    public long getId() {
        return command_id;
    }

    public void setId(long id) {
        this.command_id = id;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}