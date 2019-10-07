package server.middlewares;

import mistory.entities.Client;
import mistory.Server;
import mistory.interfaces.Middleware;
import mistory.interfaces.Packet;
import packets.UnAuthPacket;

public class MustAuthMiddleware implements Middleware {
    @Override
    public boolean execute(Client client, Server server, Packet packet) {
//        client.send(new UnAuthPacket());
        return client.getUser() != null;
    }
}
