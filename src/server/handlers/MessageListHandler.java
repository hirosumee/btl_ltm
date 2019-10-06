package server.handlers;

import mistory.Server;
import mistory.entities.Client;
import mistory.interfaces.ServerHandleable;
import packets.MessageLoadPacket;
import packets.MessageLoadSuccessPacket;
import packets.TextMessagePacket;
import server.dtos.MessageTextDTO;
import server.daos.MessageTextDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MessageListHandler implements ServerHandleable {
    @Override
    public void execute(Client client, Server server) {
        MessageLoadPacket packet = (MessageLoadPacket) client.getPacket();
        List<MessageTextDTO>
                messages =
                new MessageTextDAO().getByRoomId(packet.id).stream().map(i -> (MessageTextDTO) i)
                        .collect(Collectors.toList());
        List<TextMessagePacket> mp = messages.stream().map(i -> {
            TextMessagePacket ms = new TextMessagePacket();
            ms.sender = i.username;
            ms.date = i.time;
            ms.id_room = i.id_room;
            ms.content = i.content;
            return ms;
        }).collect(Collectors.toList());
        MessageLoadSuccessPacket pk = new MessageLoadSuccessPacket((ArrayList) mp);
        System.out.println(pk.getMessages().size());
        System.out.println("dm");
        System.out.println(pk);
        client.send(pk);
    }
}
