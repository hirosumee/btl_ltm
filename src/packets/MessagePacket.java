package packets;

import mistory.interfaces.Packet;

import java.util.Date;

public class MessagePacket implements Packet {
    static final long serialVersionUID = 1L;
    public static String _type = "message.new";
    public int id_room;
    public String sender;
    public Date date;
    @Override
    public String getType() {
        return _type;
    }
}
