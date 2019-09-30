package packets;

import mistory.interfaces.Packet;

public class RegisterSuccessfulPacket implements Packet {
    private String username;

    public RegisterSuccessfulPacket(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getType() {
        return "register.success";
    }
}
