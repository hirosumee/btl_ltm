/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.handlers;

import mistory.Client;
import mistory.Server;
import mistory.interfaces.Handleable;
import mistory.interfaces.Packet;
import packets.LoginFailedPacket;
import packets.LoginPacket;
import packets.LoginSuccessfulPacket;
import server.daos.UserDTO;
import server.dtos.UserDAO;
import server.exceptions.RecordNotFoundException;

/**
 * @author hirosume
 */
public class LoginHandler implements Handleable {

    @Override
    public void execute(Client client, Server server) {
        Packet packet = client.getPacket();
        LoginPacket loginPacket =  (LoginPacket) packet;
        try {
            UserDTO userDTO = new UserDAO().findByUsername(loginPacket.getUsername());
            boolean isValid = userDTO.comparePassword(loginPacket.getPassword());
            if(!isValid) {
                System.out.println("Login failed");
                return;
            }
            client.setUser(userDTO);
            client.send(new LoginSuccessfulPacket());
            System.out.println(isValid);
        } catch (RecordNotFoundException e) {
            System.out.println("user not found");
            client.send(new LoginFailedPacket("Tài khoản hoặc mật khẩu sai"));
        }
    }

}
