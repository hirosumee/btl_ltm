package packets;

import mistory.interfaces.Packet;

import java.util.ArrayList;

// request and response
public class RoomMemberPacket implements Packet {
    public static final String type = "room.member";
    private static final long serialVersionUID = 1L;
    private int roomId = -1;
    private ArrayList<String> members = new ArrayList<String>();

    public int getRoomId() {
        return roomId;
    }

    public RoomMemberPacket(int id) {
        this.roomId = id;
    }

    @Override
    public String getType() {
        return type;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<String> members) {
        this.members = members;
    }

}