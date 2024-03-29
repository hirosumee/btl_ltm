/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import packets.*;
import server.daos.UserDAO;
import server.dtos.UserDTO;
import server.handlers.*;
import server.middlewares.MustAuthMiddleware;
import server.vendor.DbConnection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author hirosume
 */
public class ChatServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException {
        DbConnection.getInstance();
        ArrayList<UserDTO> userDTOS = new UserDAO().searchByUsername("a");
        System.out.println(userDTOS.size());
        mistory.Server server = new mistory.Server(3000);
        server.registerMiddlewareExclude(LoginPacket.type);
        server.registerMiddlewareExclude(RegisterPacket.type);
        server.registerMiddleware(new MustAuthMiddleware());
        server.registerHandler(LoginPacket.type, new LoginHandler());
        server.registerHandler(RegisterPacket.type, new RegisterHandler());
        server.registerHandler(RoomListPacket.type, new RoomListHandler());
        server.registerHandler(TextMessagePacket._type, new MessageNewHandler());
        server.registerHandler(RoomCreatePacket.type, new RoomCreateHandler());
        server.registerHandler(MessageLoadPacket.type, new MessageListHandler());
        server.registerHandler(RoomInfoPacket.type, new RoomInfoHandler());
        server.registerHandler(GroupCreatePacket.type, new GroupCreateHandler());
        server.registerHandler(GroupInvitePacket.type, new GroupInviteHandler());
        server.registerHandler(GroupKickPacket.type, new GroupKickHandler());
        server.registerHandler(UserFindPacket.type, new UserFindHandler());
        server.registerHandler(RoomMemberPacket.type, new RoomMemberHandler());
        server.listen();
    }

}
