package server.handlers;

import mistory.entities.Client;
import mistory.Server;
import mistory.interfaces.ServerHandleable;
import packets.GroupInvitePacket;
import packets.GroupInviteSuccessfulPacket;
import server.daos.JoinDAO;
import server.dtos.UserDTO;

public class GroupInviteHandler implements ServerHandleable {
    @Override
    public void execute(Client client, Server server) {
        GroupInvitePacket packet = (GroupInvitePacket) client.getPacket();
        UserDTO userDTO = (UserDTO) client.getUser();
        new JoinDAO().create(packet.getRoomId(), packet.getFriendUsername(), userDTO.getUsername());
        client.send(new GroupInviteSuccessfulPacket(packet.getRoomId(), packet.getFriendUsername()));
    }
}
