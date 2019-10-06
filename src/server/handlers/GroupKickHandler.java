package server.handlers;

import mistory.entities.Client;
import mistory.Server;
import mistory.interfaces.ServerHandleable;
import packets.GroupKickPacket;
import packets.GroupKickSuccessfulPacket;
import server.daos.JoinDAO;

public class GroupKickHandler implements ServerHandleable {
    @Override
    public void execute(Client client, Server server) {
        GroupKickPacket packet = (GroupKickPacket) client.getPacket();
        new JoinDAO().removeByRoomAndUser(packet.getRoomId(), packet.getUsername());
        client.send(new GroupKickSuccessfulPacket(packet.getUsername(), packet.getRoomId()));
    }
}
