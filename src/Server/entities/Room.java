/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.entities;

import Server.Client;
import Server.interfaces.Packet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hirosume
 */
public class Room {
	private String name;

	public Room(String name) {
		this.name = name;
	}
	
	private List<Client> clients = new ArrayList<>();
	public void send(Packet packet) {
		this.clients.forEach(client -> client.send(packet));
	}
	public void join(Client client) {
		this.clients.add(client);
		client.addRoom(this);
	}
	public void leave(Client client) {
		this.clients.remove(client);
	}
	//get and set
	public String getName() {
		return name;
	}
	
}
