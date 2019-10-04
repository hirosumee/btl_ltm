package packets;

import mistory.interfaces.Packet;

public class MessageLoadPacket implements Packet {
    private static final long serialVersionUID = 1L;
    public static final String type = "message.load";
    public int id;

    public MessageLoadPacket(int id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String getType() {
        return type;
    }
}
