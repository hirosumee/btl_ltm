/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import mistory.Server;
import java.io.IOException;

import packets.LoginPacket;
import packets.RegisterPacket;
import server.handlers.*;
import server.middlewares.MustAuthMiddleware;

/**
 *
 * @author hirosume
 */
public class ChatServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        mistory.Server server = new mistory.Server(3000);
        server.registerMiddlewareExclude(LoginPacket.type);
        server.registerMiddlewareExclude(LoginPacket.type);
        server.registerMiddleware(new MustAuthMiddleware());
		server.registerHandler(LoginPacket.type, new LoginHandler());
		server.registerHandler(RegisterPacket.type, new RegisterHandler());
		server.registerHandler("room.list", new RoomListHandler());
		server.registerHandler("room.info", new RoomInfoHandler());
		server.registerHandler("room.create", new RoomCreateHandler());
		server.registerHandler("message.new", new MessageNewHandler());
		server.registerHandler("message.list", new MessageListHandler());
		server.registerHandler("group.invite", new GroupInviteHandler());
		server.registerHandler("group.kick", new GroupKickHandler());
		server.listen();
    }
    
}
