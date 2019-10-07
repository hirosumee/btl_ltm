package packets;

import mistory.interfaces.Packet;

public class RoomCreatePacket implements Packet {
    static final long serialVersionUID = 1L;
    public static final String type = "room.create";

    private String friendUsername;
    private String roomName;
    public RoomCreatePacket(String friendUsername, String roomName) {
        this.friendUsername = friendUsername;
        this.roomName = roomName;
    }

    public String getFriendUsername() {
        return friendUsername;
    }

    public void setFriendUsername(String friendUsername) {
        this.friendUsername = friendUsername;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public String getType() {
        return type;
    }
}
