/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import packets.*;
import server.handlers.*;
import server.middlewares.MustAuthMiddleware;

import java.io.IOException;

/**
 * @author hirosume
 */
public class ChatServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        mistory.Server server = new mistory.Server(3000);
        server.registerMiddlewareExclude(LoginPacket.type);
        server.registerMiddlewareExclude(RegisterPacket.type);
        server.registerMiddleware(new MustAuthMiddleware());
        server.registerHandler(LoginPacket.type, new LoginHandler());
        server.registerHandler(RegisterPacket.type, new RegisterHandler());
        server.registerHandler(RoomListPacket.type, new RoomListHandler());
        server.registerHandler(TextMessagePacket._type, new MessageNewHandler());
        server.registerHandler("room.info", new RoomInfoHandler());
        server.registerHandler("room.create", new RoomCreateHandler());
        server.registerHandler(MessageLoadPacket.type, new MessageListHandler());
        server.registerHandler("group.invite", new GroupInviteHandler());
        server.registerHandler("group.kick", new GroupKickHandler());
        server.listen();
    }

}
