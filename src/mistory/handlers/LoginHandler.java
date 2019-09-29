/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mistory.handlers;

import Server.Client;
import Server.Server;
import Server.interfaces.Handleable;

/**
 *
 * @author hirosume
 */
public class LoginHandler implements Handleable {

	@Override
	public void execute(Client client, Server server) {
		System.out.println(client.getPacket().getType());
	}
	
}
