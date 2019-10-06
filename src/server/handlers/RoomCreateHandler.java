package server.handlers;

import mistory.entities.Client;
import mistory.Server;
import mistory.interfaces.ServerHandleable;
import packets.RoomCreatePacket;
import packets.RoomCreateSuccessfulPacket;
import server.daos.RoomDAO;
import server.dtos.UserDTO;

import java.util.ArrayList;

public class RoomCreateHandler implements ServerHandleable {
    @Override
    public void execute(Client client, Server server) {
        RoomCreatePacket packet = (RoomCreatePacket) client.getPacket();
        UserDTO user = (UserDTO) client.getUser();
        ArrayList<String> members = new ArrayList<>();
        members.add(user.getUsername());
        members.add(packet.getFriendUsername());
        new RoomDAO().createInbox(user.getUsername(), members);
        client.send(new RoomCreateSuccessfulPacket());
    }
}
