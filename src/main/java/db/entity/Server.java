package db.entity;

import javax.persistence.*;

@Entity
@Table(name = "Server")
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long server_id;

    @Column(name = "ip", nullable = false)
    private String ip;

    @Column(name = "port", nullable = false)
    private String port;

    @Column(name = "tech_user_id", nullable = false)
    private int tech_user_id;

    @Column(name = "code")
    private String code;

    public Server(String ip, String port, int tech_user_id, String code) {
        this.ip = ip;
        this.port = port;
        this.tech_user_id = tech_user_id;
        this.code = code;
    }

    public long getServer_id() {
        return server_id;
    }

    public void setServer_id(long server_id) {
        this.server_id = server_id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public int getTech_user_id() {
        return tech_user_id;
    }

    public void setTech_user_id(int tech_user_id) {
        this.tech_user_id = tech_user_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
