package server.daos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageTextDTO extends MessageDTO {
    public String content;

    public static MessageTextDTO fromResultSet(ResultSet rs) throws SQLException {
        MessageTextDTO fl = new MessageTextDTO();
        fl.username = rs.getString(1).trim();
        fl.id_room = rs.getInt(2);
        fl.id_join = rs.getInt(3);
        fl.content = rs.getString(4).trim();

        fl.id = rs.getInt(5);
        fl.time = rs.getDate(6);
        return fl;
    }
}
