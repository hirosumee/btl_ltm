/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.packets;

import Server.interfaces.Packet;
import java.io.Serializable;

/**
 *
 * @author hirosume
 */
public class LoginPacket implements Packet, Serializable {

	private String type = "login";

	@Override
	public String getType() {
		return type;
	}

}
