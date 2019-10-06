package packets;

import mistory.interfaces.Packet;

public class GroupInviteSuccessfulPacket implements Packet {
    public static final String type = "group.invite.success";
    static final long serialVersionUID = 1L;
    private int idRoom;
    private String username;

    public GroupInviteSuccessfulPacket(int idRoom, String username) {
        this.idRoom = idRoom;
        this.username = username;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String getType() {
        return type;
    }
}
