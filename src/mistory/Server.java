/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mistory;

import mistory.entities.ClientThread;
import mistory.entities.Room;
import mistory.interfaces.Handleable;
import mistory.interfaces.Middleware;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author hirosume
 */
public class Server extends ServerSocket {

    private Map<String, Room> rooms = new HashMap<>();
    private Map handlers = new HashMap<String, Handleable>();
    private Set middlewares = new HashSet<Middleware>();
    private Set<String> excludeMiddlewaresCheck = new HashSet<>();

    public Server() throws IOException {
        super(3000);
    }

    public Server(int port) throws IOException {
        super(port);
    }

    public void listen() {
        System.out.println(String.format("Server has started on %d.\r\nWaiting for a connection", this.getLocalPort()));
        while (true) {
            try {
                Socket client = this.accept();
                System.out.println("A client is connected");
                Thread thread = new ClientThread(client, this);
                thread.start();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void registerHandler(String name, Handleable handler) {
        this.handlers.put(name, handler);
    }

    public void registerMiddleware(Middleware middleware) {
        this.middlewares.add(middleware);
    }

    public void registerMiddlewareExclude(String packetType) {
        this.excludeMiddlewaresCheck.add(packetType);
    }

    public void unregisterMiddlewareExclude(String packageType) {
        this.excludeMiddlewaresCheck.remove(packageType);
    }

    public boolean hasExclude(String packetType) {
        return this.excludeMiddlewaresCheck.contains(packetType);
    }
    //get and set

    public Map<String, Room> getRooms() {
        return rooms;
    }

    public boolean addRoom(Room room) {
        if (this.rooms.containsKey(room.getName())) return false;
        this.rooms.put(room.getName(), room);
        return true;
    }
    public Room removeRoom(String name) {
        return this.rooms.remove(name);
    }
    public Room removeRoom(Room room) {
        return this.rooms.remove(room.getName());
    }

    public Map<String, Handleable> getHandlers() {
        return handlers;
    }

    public Set<Middleware> getMiddlewares() {
        return middlewares;
    }


}
