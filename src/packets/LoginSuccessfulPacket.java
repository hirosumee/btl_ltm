package packets;

import mistory.interfaces.Packet;

public class LoginSuccessfulPacket implements Packet {
    static final long serialVersionUID = 1L;
    public static final String type = "login.successful";
    private String username;

    public LoginSuccessfulPacket(String username) {
        this.username = username;
    }

    public LoginSuccessfulPacket() {
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String getType() {
        return type;
    }
}
