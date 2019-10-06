package server.handlers;

import mistory.Server;
import mistory.entities.Client;
import mistory.entities.Room;
import mistory.interfaces.ServerHandleable;
import packets.TextMessagePacket;
import server.dtos.JoinDTO;
import server.dtos.UserDTO;
import server.daos.MessageTextDAO;
import server.utils.RoomUtils;

public class MessageNewHandler implements ServerHandleable {
    @Override
    public void execute(Client client, Server server) {
        TextMessagePacket packet = (TextMessagePacket) client.getPacket();
        System.out.println(packet.content);
        UserDTO user = (UserDTO) client.getUser();
        JoinDTO join = RoomUtils.getFirstJoin(user.getUsername(), packet.id_room);
        if (join != null) {
            new MessageTextDAO().create(join.getId(), join.getId_room(), packet.content, user.getUsername());
            packet.sender = user.getUsername();
            //emit
            Room room = server.getRoom(String.valueOf(join.getId_room()));
            if (room != null) {
                room.send(packet);
            }
        }
    }
}
