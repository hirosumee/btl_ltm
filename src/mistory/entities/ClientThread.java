/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mistory.entities;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import mistory.Server;
import mistory.exceptions.ReadPacketException;

/**
 *
 * @author hirosume
 */
public class ClientThread extends Thread {

	private Client client;

	public ClientThread(Socket socket, Server server) {
		try {
			client = new Client(socket, server);
		} catch (IOException ex) {
			Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void run() {
		try {
			client.listen();
		} catch (ReadPacketException ex) {
			try {
				System.out.println("socket is closed");
				client.close();
				this.stop();
			} catch (IOException ex1) {
				Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex1);
			}
		}
	}

}
