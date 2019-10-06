package packets;

import mistory.interfaces.Packet;

import java.util.ArrayList;

public class UserFindSuccessPacket implements Packet {
    public static final String type = "user.find.success";
    ArrayList<String> usernames;

    public ArrayList<String> getUsernames() {
        return usernames;
    }

    public UserFindSuccessPacket(ArrayList<String> usernames) {
        this.usernames = usernames;
    }

    @Override
    public String getType() {
        return type;
    }
}
