package mistory.Driver;

import mistory.interfaces.Packet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Client {
    private Socket socket;
    private ObjectOutputStream oos;
    private Map<String, Handleable> events = new HashMap<>();
    Thread thread;

    public Client() throws IOException {
        init(3000);
    }

    public Client(int port) throws IOException {
        init(port);
    }

    private void init(int port) throws IOException {
        socket = new Socket(InetAddress.getLocalHost(), port);
        oos = new ObjectOutputStream(socket.getOutputStream());
        this.initListener();
    }

    private void initListener() {
         thread = new Listener(this.socket, this.events);
        thread.start();
    }

    public void close() throws IOException {
        socket.close();
//        oos.close();
//        socket.getInputStream().close();
//        socket.getOutputStream().close();
        thread.stop();
    }

    public void addListener(String event, Handleable handler) {
        this.events.put(event, handler);
    }

    public void removeListener(String event) {
        this.events.remove(event);
    }

    public boolean send(Packet packet) {
        try {
            oos.writeObject(packet);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
