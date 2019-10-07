/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mistory;

import mistory.entities.ClientThread;
import mistory.entities.Room;
import mistory.interfaces.ServerHandleable;
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
    private Map<String, ServerHandleable> handlers = new HashMap<>();
    private Set<Middleware> middlewares = new HashSet<>();
    private Set<String> excludeMiddlewaresCheck = new HashSet<>();

    public Server() throws IOException {
        super(3000);
    }

    public Server(int port) throws IOException {
        super(port);
    }

    public void listen() {
        System.out.println(String.format("Server has started on %d.\r\nWaiting for a connection", this.getLocalPort()));
        while (!this.isClosed()) {
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

    public void registerHandler(String name, ServerHandleable handler) {
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

    public synchronized boolean hasExclude(String packetType) {
        return this.excludeMiddlewaresCheck.contains(packetType);
    }
    //get and set

    public synchronized Map<String, Room> getRooms() {
        return rooms;
    }

    public synchronized Room addRoom(String name) {
        if (this.rooms.containsKey(name)) return this.rooms.get(name);
        Room room = new Room(name);
        this.rooms.put(name, room);
        return room;
    }
    public synchronized boolean addRoom(Room room) {
        if (this.rooms.containsKey(room.getName())) return false;
        this.rooms.put(room.getName(), room);
        return true;
    }
    public synchronized Room getRoom(String name) {
        return this.rooms.get(name);
    }
    public synchronized Room removeRoom(String name) {
        return this.rooms.remove(name);
    }
    public synchronized Room removeRoom(Room room) {
        return this.rooms.remove(room.getName());
    }

    public synchronized Map<String, ServerHandleable>  getHandlers() {
        return handlers;
    }

    public synchronized Set<Middleware> getMiddlewares() {
        return middlewares;
    }


}
