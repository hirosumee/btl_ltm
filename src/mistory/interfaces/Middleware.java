/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mistory.interfaces;

import mistory.Client;
import mistory.Server;

/**
 *
 * @author hirosume
 */
public interface Middleware {
	boolean execute(Client client, Server server, Packet packet);
}
