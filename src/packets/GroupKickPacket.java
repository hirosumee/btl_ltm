package packets;

import mistory.interfaces.Packet;

public class GroupKickPacket implements Packet {

    static final long serialVersionUID = 1L;
    public static final String type = "group.kick";
    private int roomId;
    private String username;

    public GroupKickPacket(int roomId, String username) {
        this.roomId = roomId;
        this.username = username;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String getType() {
        return type;
    }
}
