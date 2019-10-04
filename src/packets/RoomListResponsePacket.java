package packets;

import mistory.interfaces.Packet;
import server.daos.RoomDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoomListResponsePacket implements Packet {

    static final long serialVersionUID = 1L;
    public static final String type = "room.list.response";
    private List<RoomPacket> list = new ArrayList<>();

    public RoomListResponsePacket(List<RoomPacket> list) {
        this.list = list;
    }


    public List<RoomPacket> getList() {
        return list;
    }

    @Override
    public String getType() {
        return type;
    }
}
