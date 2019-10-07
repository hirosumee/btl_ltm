package packets;

import mistory.interfaces.Packet;

public class UserFindPacket implements Packet {

    static final long serialVersionUID = 1L;
    public static final String type = "user.find";
    private String username;

    public UserFindPacket(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String getType() {
        return type;
    }
}
