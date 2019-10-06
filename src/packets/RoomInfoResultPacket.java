package packets;

import mistory.interfaces.Packet;

import java.util.ArrayList;
import java.util.Date;

public class RoomInfoResultPacket implements Packet {
    public static final String _type = "room.info.result";
    private static final long serialVersionUID = 1L;
    private int id;
    private String groupIP;
    private String type;
    private String creator;
    private Date time;
    private Date update_time;
    private ArrayList<String> members;

    public RoomInfoResultPacket(int id, String groupIP, String type, String creator, Date time, Date update_time,
                                ArrayList<String> members) {
        this.id = id;
        this.groupIP = groupIP;
        this.type = type;
        this.creator = creator;
        this.time = time;
        this.update_time = update_time;
        this.members = members;
    }

    public static String get_type() {
        return _type;
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

    public ArrayList<String> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<String> members) {
        this.members = members;
    }

    @Override
    public String getType() {
        return _type;
    }
}
