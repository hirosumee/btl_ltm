/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mistory;

import Server.Server;
import java.io.IOException;
import mistory.handlers.LoginHandler;

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
		server.listen();
    }
    
}
