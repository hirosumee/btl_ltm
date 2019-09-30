package packets;

import mistory.interfaces.Packet;

public class UnAuthPacket implements Packet {

    @Override
    public String getType() {
        return "UnAuth";
    }
}
