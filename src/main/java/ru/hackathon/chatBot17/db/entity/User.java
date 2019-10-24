package ru.hackathon.chatBot17.db.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Entity for mapping the User table
 */
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "users")
    private Collection<Server> servers;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
