package packets;

import mistory.interfaces.Packet;

public class GroupKickSuccessfulPacket implements Packet {
    public static final String type = "group.kick.success";
    private String username;
    private int roomId;

    public GroupKickSuccessfulPacket(String username, int roomId) {
        this.username = username;
        this.roomId = roomId;
    }

    public String getUsername() {
        return username;
    }

    public int getRoomId() {
        return roomId;
    }

    @Override
    public String getType() {
        return null;
    }
}
