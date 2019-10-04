package mistory.Driver;

import mistory.interfaces.Packet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Map;

public class Listener extends Thread {
    Socket socket;
    Map<String, Handleable> events;

    public Listener(Socket socket, Map<String, Handleable> events) {
        this.socket = socket;
        this.events = events;
    }

    private void init() throws IOException {
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        while (!socket.isClosed()) {
            try {
                Packet packet = (Packet) ois.readObject();
                String type = packet.getType();
                if (events.containsKey(type)) {
                    events.get(type).execute(packet);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    @Override
    public void run() {
        try {
            this.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
