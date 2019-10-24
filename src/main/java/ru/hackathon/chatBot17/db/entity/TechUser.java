package ru.hackathon.chatBot17.db.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "TechUser")
public class TechUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tech_user_id;

    @Column(name = "login")
    private String login;

    @Column(name = "pass")
    private String pass;

    @OneToMany(mappedBy = "tech_user_id")
    private Collection<Server> servers;

    public TechUser() {

    }

    public TechUser(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String logic) {
        this.login = logic;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
