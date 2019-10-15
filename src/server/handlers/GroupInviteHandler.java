package server.handlers;

import mistory.Server;
import mistory.entities.Client;
import mistory.interfaces.ServerHandleable;
import packets.GroupInvitePacket;
import packets.GroupInviteSuccessfulPacket;
import server.daos.JoinDAO;
import server.daos.RoomDAO;
import server.dtos.UserDTO;

public class GroupInviteHandler implements ServerHandleable {
    @Override
    public void execute(Client client, Server server) {
        GroupInvitePacket packet = (GroupInvitePacket) client.getPacket();
        UserDTO userDTO = (UserDTO) client.getUser();
        JoinDAO dao = new JoinDAO();
        RoomDAO roomDAO = new RoomDAO();
        if (dao.isExist(packet.getFriendUsername(), packet.getRoomId()) && roomDAO.isGroup(packet.getRoomId())) {
            return;
        }
        dao.create(packet.getRoomId(), packet.getFriendUsername(), userDTO.getUsername());
        client.send(new GroupInviteSuccessfulPacket(packet.getRoomId(), packet.getFriendUsername()));
    }
}
