/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mistory.interfaces;

import java.io.Serializable;

/**
 *
 * @author hirosume
 */
public interface Packet extends Serializable {
	String getType();
}
