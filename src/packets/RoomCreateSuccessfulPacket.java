package packets;

import mistory.interfaces.Packet;

public class RoomCreateSuccessfulPacket implements Packet {
    static final long serialVersionUID = 1L;
    public static final String type = "room.create.success";
    @Override
    public String getType() {
        return type;
    }
}
