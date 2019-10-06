package packets;

import mistory.interfaces.Packet;

public class RoomCreatePacket implements Packet {
    static final long serialVersionUID = 1L;
    public static final String type = "room.create";

    private String friendUsername;

    public RoomCreatePacket(String friendUsername) {
        this.friendUsername = friendUsername;
    }

    public String getFriendUsername() {
        return friendUsername;
    }

    public void setFriendUsername(String friendUsername) {
        this.friendUsername = friendUsername;
    }

    @Override
    public String getType() {
        return type;
    }
}
