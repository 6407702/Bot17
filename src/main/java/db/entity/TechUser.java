package db.entity;

import javax.persistence.*;

@Entity
@Table(name = "TechUser")
public class TechUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tech_user_id;

    @Column(name = "logic")
    private String logic;

    @Column(name = "pass")
    private String pass;

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
