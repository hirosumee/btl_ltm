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

/**
 *
 * @author hirosume
 */
public class Mistory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Server server = new Server(3000);
		server.registerHandler("login", new LoginHandler());
		server.registerHandler("register", new RegisterHandler());
		server.listen();
    }
    
}
