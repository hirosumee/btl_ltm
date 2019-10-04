package packets;

import mistory.interfaces.Packet;

public class RegisterFailedPacket implements Packet {
    static final long serialVersionUID = 1L;
    public static String type = "register.failed";
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RegisterFailedPacket() {
    }

    public RegisterFailedPacket(String message) {
        this.message = message;
    }

    private String message = "";
    @Override
    public String getType() {
        return type;
    }
}
