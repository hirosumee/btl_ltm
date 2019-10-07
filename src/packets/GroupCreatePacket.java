package packets;

import mistory.interfaces.Packet;


public class GroupCreatePacket implements Packet {
    static final long serialVersionUID = 1L;
    public static final String type = "group.create";
    private String name;

    public GroupCreatePacket(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getType() {
        return type;
    }
}
