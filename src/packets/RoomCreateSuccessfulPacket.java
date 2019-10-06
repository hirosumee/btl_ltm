package packets;

import mistory.interfaces.Packet;

public class RoomCreateSuccessfulPacket implements Packet {
    public static final String type = "room.create.success";
    @Override
    public String getType() {
        return type;
    }
}
