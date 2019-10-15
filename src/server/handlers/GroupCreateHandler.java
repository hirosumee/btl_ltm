package server.handlers;

import mistory.Server;
import mistory.entities.Client;
import mistory.interfaces.ServerHandleable;
import packets.GroupCreatePacket;
import server.daos.RoomDAO;
import server.dtos.UserDTO;

public class GroupCreateHandler implements ServerHandleable {
    @Override
    public void execute(Client client, Server server) {
        GroupCreatePacket packet = (GroupCreatePacket) client.getPacket();
        UserDTO user = (UserDTO) client.getUser();
        new RoomDAO().createGroup(user.getUsername(), packet.getName());
    }
}
