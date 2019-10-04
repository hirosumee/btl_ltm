package server.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class JoinDTO {
    private int id;
    private String username;
    private Date time;
    private int id_room;
    private  String adder;

    public JoinDTO(int id, String username, Date time, int id_room, String adder) {
        this.id = id;
        this.username = username;
        this.time = time;
        this.id_room = id_room;
        this.adder = adder;
    }

    public JoinDTO() {
    }

    public static JoinDTO fromResultSet(ResultSet rs ) throws SQLException {
        JoinDTO d =  new JoinDTO();
        d.username = rs.getString(1).trim();
        d.time = rs.getDate(2);
        d.id_room = rs.getInt(3);
        d.adder = rs.getString(4).trim();
        d.id = rs.getInt(5);
        return d;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public String getAdder() {
        return adder;
    }

    public void setAdder(String adder) {
        this.adder = adder;
    }
}
