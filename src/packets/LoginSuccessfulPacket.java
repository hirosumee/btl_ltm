package packets;

import mistory.interfaces.Packet;

public class LoginSuccessfulPacket implements Packet {
    private final String type = "login.successful";
    @Override
    public String getType() {
        return type;
    }
}
