package server.handlers;

import mistory.entities.Client;
import mistory.Server;
import mistory.entities.Room;
import mistory.interfaces.ServerHandleable;
import server.daos.RoomDTO;
import server.daos.UserDTO;
import server.dtos.RoomDAO;
import server.utils.RoomListUtils;

import java.util.List;

public class RoomListHandler implements ServerHandleable {
    @Override
    public void execute(Client client, Server server) {
        UserDTO user = (UserDTO)client.getUser();
        List<RoomDTO> list = new RoomDAO().getFromUsername(user.getUsername());
        joinAll(list, server, client);
        client.send(RoomListUtils.fromRoomList(list));
    }
    private void joinAll(List<RoomDTO> list, Server server, Client client) {
       list.forEach(i -> {
          Room room = server.addRoom(String.valueOf(i.getId()));
          room.join(client);
       });
    }
}
