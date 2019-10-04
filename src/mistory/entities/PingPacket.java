package mistory.entities;

import mistory.interfaces.Packet;

public class PingPacket implements Packet {
    public static String type = "ping";
    @Override
    public String getType() {
        return type;
    }
}
