/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Server.interfaces.Packet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hirosume
 */
public class ClientTest {
	static class LoginPacket implements Packet,Serializable {
		private String type = "login";
		@Override
		public String getType() {
			return type;
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		try {
			Socket socket = new Socket(InetAddress.getLocalHost(), 3000);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//			oos.writeBytes("abc");
			oos.writeObject(new ClientTest.LoginPacket());
			oos.flush();
			oos.writeObject(new ClientTest.LoginPacket());
			oos.flush();
			Thread.sleep(5000);
//			socket.close();
		} catch (IOException ex) {
			Logger.getLogger(ClientTest.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
