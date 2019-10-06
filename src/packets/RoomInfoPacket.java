package packets;

import mistory.interfaces.Packet;

public class RoomInfoPacket implements Packet {
    public static final String type = "room.info";
    static final long serialVersionUID = 1L;
    private int room_id;

    public RoomInfoPacket(int room_id) {
        this.room_id = room_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    @Override
    public String getType() {
        return type;
    }
}
