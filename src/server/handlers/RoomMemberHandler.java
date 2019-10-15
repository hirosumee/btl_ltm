package server.handlers;

import mistory.Server;
import mistory.entities.Client;
import mistory.interfaces.ServerHandleable;
import packets.RoomMemberPacket;
import server.daos.JoinDAO;
import server.dtos.JoinDTO;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class RoomMemberHandler implements ServerHandleable {
    @Override
    public void execute(Client client, Server server) {
        RoomMemberPacket packet = (RoomMemberPacket) client.getPacket();
        System.out.println(packet.getRoomId());
        ArrayList<JoinDTO> list = new JoinDAO().findByRoom(packet.getRoomId());
        ArrayList<String> members = new ArrayList<>();
        members = (ArrayList<String>) list.stream().map(i -> i.getUsername()).collect(Collectors.toList());
        packet.setMembers(members);
        client.send(packet);
    }
}
