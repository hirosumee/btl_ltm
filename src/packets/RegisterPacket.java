package packets;

import mistory.interfaces.Packet;

public class RegisterPacket implements Packet {
    private final String type = "register" ;
    private String username;
    private String password;

    public RegisterPacket(String username, String password) {
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
        return "RegisterPacket{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public String getType() {
        return type;
    }
}
