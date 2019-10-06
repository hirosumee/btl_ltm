package packets;

import mistory.interfaces.Packet;

public class GroupInvitePacket implements Packet {
    static final long serialVersionUID = 1L;
    public static final String type = "group.invite";
    private int roomId;
    private String friendUsername;

    public GroupInvitePacket(int roomId, String friendUsername) {
        this.roomId = roomId;
        this.friendUsername = friendUsername;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getFriendUsername() {
        return friendUsername;
    }

    @Override
    public String getType() {
        return type;
    }
}
