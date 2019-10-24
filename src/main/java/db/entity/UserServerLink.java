package db.entity;

import javax.persistence.*;

@Entity
@Table(name = "UserServerLink")
public class UserServerLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_server_link_id;

    @Column(name = "tech_id", nullable = false)
    private int tech_id;

    @Column(name = "user_id", nullable = false)
    private int user_id;

    public UserServerLink(int tech_id, int user_id) {
        this.tech_id = tech_id;
        this.user_id = user_id;
    }

    public long getUser_server_link_id() {
        return user_server_link_id;
    }

    public void setUser_server_link_id(long user_server_link_id) {
        this.user_server_link_id = user_server_link_id;
    }

    public int getTech_id() {
        return tech_id;
    }

    public void setTech_id(int tech_id) {
        this.tech_id = tech_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
