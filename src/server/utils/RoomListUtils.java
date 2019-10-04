package server.utils;

import packets.RoomListResponsePacket;
import packets.RoomPacket;
import server.daos.RoomDTO;

import java.util.List;
import java.util.stream.Collectors;

public class RoomListUtils {
    public static RoomListResponsePacket fromRoomList(List<RoomDTO> list) {
        return new RoomListResponsePacket(list.stream().map(RoomUtils::fromRoom).collect(Collectors.toList()));
    }
}
