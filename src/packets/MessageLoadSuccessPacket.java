package packets;

import mistory.interfaces.Packet;

import java.util.ArrayList;

public class MessageLoadSuccessPacket implements Packet {
    public static final String type = "message.load.success";
    private static final long serialVersionUID = 1L;
    ArrayList<MessagePacket> messages = new ArrayList<>();

    public MessageLoadSuccessPacket(ArrayList<MessagePacket> messages) {
        this.messages = messages;
    }

    public ArrayList<MessagePacket> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<MessagePacket> messages) {
        this.messages = messages;
    }

    @Override
    public String getType() {
        return type;
    }
}
