package ru.hackathon.chatBot17.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "Type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long type_id;

    @Column(name = "types", nullable = false)
    private String commands;

    public Type(String commands) {
        this.commands = commands;
    }

    public long getId() {
        return type_id;
    }

    public void setId(Integer id) {
        this.type_id = id;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }
}
