package server.handlers;

import mistory.Client;
import mistory.Server;
import mistory.interfaces.Handleable;
import mistory.interfaces.Packet;
import packets.RegisterPacket;
import server.daos.UserDTO;
import server.dtos.UserDAO;
import server.exceptions.RecordNotFoundException;

import java.security.NoSuchAlgorithmException;

public class RegisterHandler implements Handleable {
    @Override
    public void execute(Client client, Server server) {
        Packet packet = client.getPacket();
        RegisterPacket registerPacket = (RegisterPacket) packet;
        UserDAO userDAO = new UserDAO();
        try {
            userDAO.findByUsername(registerPacket.getUsername());
            System.out.println("user is exist");
        } catch (RecordNotFoundException e) {
            try {
                UserDTO userDTO = new UserDTO(registerPacket.getUsername(), registerPacket.getPassword());
                userDAO.create(userDTO);
                System.out.println(userDTO);
            } catch (NoSuchAlgorithmException ex) {
                ex.printStackTrace();
            }
        }
    }
}
