package packets;

import mistory.interfaces.Packet;

public class RoomListPacket implements Packet {
    static final long serialVersionUID = 1L;
    public static String type = "room.list";
    @Override
    public String getType() {
        return type;
    }
}
