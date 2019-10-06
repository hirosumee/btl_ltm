package server.handlers;

import mistory.Server;
import mistory.entities.Client;
import mistory.interfaces.ServerHandleable;
import packets.UserFindPacket;
import packets.UserFindSuccessPacket;
import server.daos.UserDAO;
import server.dtos.UserDTO;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class UserFindHandler implements ServerHandleable {
    @Override
    public void execute(Client client, Server server) {
        UserFindPacket packet = (UserFindPacket) client.getPacket();
        ArrayList<UserDTO> userDTOS = new UserDAO().searchByUsername(packet.getUsername());
        client.send(
                new UserFindSuccessPacket(
                        (ArrayList<String>) userDTOS.stream().map(UserDTO::getUsername).collect(Collectors.toList())));
    }
}
