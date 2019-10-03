package test;

import mistory.Driver.Handleable;
import mistory.interfaces.Packet;
import packets.LoginSuccessfulPacket;

public class LoginSuccessHandler implements Handleable {
    @Override
    public void execute(Packet packet) {
        System.out.println(((LoginSuccessfulPacket) packet).getUsername());
    }
}
