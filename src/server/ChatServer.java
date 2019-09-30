/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import mistory.Server;
import java.io.IOException;
import server.handlers.LoginHandler;
import server.handlers.RegisterHandler;
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
        // TODO code application logic here
        mistory.Server server = new mistory.Server(3000);
//        server.registerMiddlewareExclude("login");
//        server.registerMiddlewareExclude("register");
        server.registerMiddleware(new MustAuthMiddleware());
		server.registerHandler("login", new LoginHandler());
		server.registerHandler("register", new RegisterHandler());
		server.listen();
    }
    
}
