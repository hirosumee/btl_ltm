package packets;

import mistory.interfaces.Packet;

import java.util.ArrayList;

public class GroupCreatePacket implements Packet {
    static final long serialVersionUID = 1L;
    public static final String type = "group.create";
    private ArrayList<String> friends;

    public GroupCreatePacket(ArrayList<String> friends) {
        this.friends = friends;
    }

    public GroupCreatePacket() {
        friends = new ArrayList<>();
    }

    public ArrayList<String> getFriends() {
        return friends;
    }

    @Override
    public String getType() {
        return type;
    }
}
