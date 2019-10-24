package db.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "TechUser")
public class TechUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tech_user_id;

    @Column(name = "logic")
    private String logic;

    @Column(name = "pass")
    private String pass;

    @OneToMany(mappedBy = "tech_user_id")
    private Collection<Server> servers;

    public TechUser(String logic, String pass) {
        this.logic = logic;
        this.pass = pass;
    }

    public String getLogic() {
        return logic;
    }

    public void setLogic(String logic) {
        this.logic = logic;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
