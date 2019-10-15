package server.handlers;

import mistory.Server;
import mistory.entities.Client;
import mistory.interfaces.ServerHandleable;
import packets.GroupKickPacket;
import packets.GroupKickSuccessfulPacket;
import server.daos.JoinDAO;
import server.daos.RoomDAO;

public class GroupKickHandler implements ServerHandleable {
    @Override
    public void execute(Client client, Server server) {
        GroupKickPacket packet = (GroupKickPacket) client.getPacket();
        JoinDAO dao = new JoinDAO();
        RoomDAO roomDAO = new RoomDAO();
        if (dao.isExist(packet.getUsername(), packet.getRoomId()) && roomDAO.isGroup(packet.getRoomId())) {
            new JoinDAO().removeByRoomAndUser(packet.getRoomId(), packet.getUsername());
            client.send(new GroupKickSuccessfulPacket(packet.getUsername(), packet.getRoomId()));
        }
    }
}
