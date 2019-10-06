package server.handlers;

import mistory.Server;
import mistory.entities.Client;
import mistory.interfaces.ServerHandleable;
import packets.RoomInfoPacket;
import packets.RoomInfoResultPacket;
import server.daos.JoinDAO;
import server.daos.RoomDAO;
import server.dtos.JoinDTO;
import server.dtos.RoomDTO;
import server.exceptions.RecordNotFoundException;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class RoomInfoHandler implements ServerHandleable {
    @Override
    public void execute(Client client, Server server) {
        RoomInfoPacket packet = (RoomInfoPacket) client.getPacket();
        try {
            RoomDTO roomDTO = new RoomDAO().getFromId(packet.getRoom_id());
            ArrayList<JoinDTO> joinDTOS = new JoinDAO().findByRoom(roomDTO.getId());
            ArrayList<String> members =
                    (ArrayList<String>) joinDTOS.stream().map(JoinDTO::getUsername).collect(Collectors.toList());
            client.send(new RoomInfoResultPacket(roomDTO.getId(), roomDTO.getGroupIP(), roomDTO.getType(),
                    roomDTO.getCreator(), roomDTO.getTime(), roomDTO.getUpdate_time(), members));
        } catch (RecordNotFoundException e) {
            e.printStackTrace();
        }
    }
}
