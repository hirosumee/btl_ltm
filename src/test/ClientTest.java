/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import mistory.Driver.Client;
import mistory.interfaces.Packet;
import packets.LoginFailedPacket;
import packets.LoginPacket;
import packets.LoginSuccessfulPacket;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hirosume
 */
public class ClientTest {
	public static void main(String[] args) throws InterruptedException {
		try {
			Packet packet = new LoginPacket("hirosume12", "1234");
			Client client = new Client();
			client.send(packet);
			client.addListener(LoginSuccessfulPacket.type, pk -> {
			    LoginSuccessfulPacket pk1 = (LoginSuccessfulPacket) pk;
				System.out.println(pk1.getUsername());
			});
			client.addListener(LoginFailedPacket.type, pk -> {
				System.out.println(((LoginFailedPacket) pk).getMessage());
			});
			Thread.sleep(1000);
			client.close();
		} catch (IOException ex) {
			Logger.getLogger(ClientTest.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
