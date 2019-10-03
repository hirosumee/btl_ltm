package packets;

import mistory.interfaces.Packet;

public class LoginFailedPacket implements Packet {
    public static final String type = "login.failed";
    private String message = "";

    public LoginFailedPacket(String message) {
        this.message = message;
    }

    public LoginFailedPacket() {
        this.message = "NaN";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getType() {
        return type;
    }
}
