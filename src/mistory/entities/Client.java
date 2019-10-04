/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mistory.entities;

import mistory.Server;
import mistory.exceptions.ReadPacketException;
import mistory.interfaces.Middleware;
import mistory.interfaces.Packet;
import mistory.interfaces.User;
import mistory.utils.Common;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author hirosume
 */
public class Client {
    private final Server server;
    private final Socket socket;
    private final ObjectInputStream in;
    private final ObjectOutputStream out;
    String id;
    private User user;
    private Set<Room> rooms = new HashSet<>();
    private Packet packet;

    {
        //generate id
        id = Common.randomString();
    }

    public Client(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        in = new ObjectInputStream(socket.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());
    }


    public void listen() throws ReadPacketException {

        while (!socket.isClosed()) {
            try {
                Packet packet = (Packet) in.readObject();
                boolean f = this.shouldContinue(packet);
                if (!f) {
                    continue;
                }
                this.packet = packet;
                this.execute();
            } catch (IOException | ClassNotFoundException ex) {
//                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                throw new ReadPacketException();
            }
        }

    }

    private void execute() {
        for (String name : this.server.getHandlers().keySet()) {
            if (name.equals(packet.getType())) {
                this.server.getHandlers().get(name).execute(this, server);
                break;
            }
        }
    }

    private boolean shouldContinue(Packet packet) {
        if (this.server.hasExclude(packet.getType())) return true;
        boolean f = true;
        for (Middleware m : this.server.getMiddlewares()) {
            f = m.execute(this, server, packet);
            if (!f) {
                return f;
            }
        }
        return f;
    }

    public void send(Packet packet) {
        try {
            out.writeObject(packet);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public void close() throws IOException {
        for (Room r : rooms) {
            r.leave(this);
        }
        this.socket.close();
    }

    //get and set
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Packet getPacket() {
        return packet;
    }

}
