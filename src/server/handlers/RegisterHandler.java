package server.handlers;

import mistory.entities.Client;
import mistory.Server;
import mistory.interfaces.ServerHandleable;
import mistory.interfaces.Packet;
import packets.RegisterFailedPacket;
import packets.RegisterPacket;
import packets.RegisterSuccessfulPacket;
import server.daos.UserDTO;
import server.dtos.UserDAO;
import server.exceptions.RecordNotFoundException;

import java.security.NoSuchAlgorithmException;

public class RegisterHandler implements ServerHandleable {
    @Override
    public void execute(Client client, Server server) {
        Packet packet = client.getPacket();
        RegisterPacket registerPacket = (RegisterPacket) packet;
        UserDAO userDAO = new UserDAO();
        try {
            userDAO.findByUsername(registerPacket.getUsername());
            System.out.println("user is exist");
            client.send(new RegisterFailedPacket("Tài khoản đã tồn tại"));
        } catch (RecordNotFoundException e) {
            try {
                UserDTO userDTO = new UserDTO(registerPacket.getUsername(), registerPacket.getPassword());
                userDAO.create(userDTO);
                System.out.println(userDTO);
                client.send(new RegisterSuccessfulPacket(registerPacket.getUsername()));
            } catch (NoSuchAlgorithmException ex) {
                ex.printStackTrace();
                client.send(new RegisterFailedPacket("Có lỗi xảy ra thử lại sau"));
            }
        }
    }
}
