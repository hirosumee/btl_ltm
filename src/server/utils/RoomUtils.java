package server.utils;

import packets.RoomPacket;
import server.dtos.JoinDTO;
import server.dtos.RoomDTO;
import server.daos.JoinDAO;

import java.util.List;

public class RoomUtils {
    public static RoomPacket fromRoom(RoomDTO roomDTO) {
        RoomPacket roomPacket = new RoomPacket();
        roomPacket.id = roomDTO.getId();
        roomPacket.creator = roomDTO.getCreator();
        roomPacket.groupIP = roomDTO.getGroupIP();
        roomPacket.time = roomDTO.getTime();
        roomPacket.update_time = roomDTO.getUpdate_time();
        roomPacket.type = roomDTO.getType();
        return roomPacket;
    }

    public static boolean isMember(String username, int id_room) {
        return new JoinDAO().findByUsernameAndRoom(username, id_room).size() > 0;
    }

    public static JoinDTO getFirstJoin(String username, int id_room) {
        List<JoinDTO> list = new JoinDAO().findByUsernameAndRoom(username, id_room);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }
}
