package packets;

import mistory.interfaces.Packet;
import server.daos.RoomDTO;

import java.util.Date;

public class RoomPacket implements Packet {
    public static final String _type = "room.packet";
    private static final long serialVersionUID = 1L;
    public int id;
    public String groupIP;
    public String type;
    public String creator;
    public Date time;
    public Date update_time;



    @Override
    public String getType() {
        return null;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupIP() {
        return groupIP;
    }

    public void setGroupIP(String groupIP) {
        this.groupIP = groupIP;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
