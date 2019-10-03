/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packets;

import mistory.interfaces.Packet;

/**
 *
 * @author hirosume
 */
public class LoginPacket implements Packet {

	public static final String type = "login";
	private String username;
	private String password;

	public LoginPacket(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginPacket{" +
				"type='" + type + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}

	@Override
	public String getType() {
		return type;
	}

}
