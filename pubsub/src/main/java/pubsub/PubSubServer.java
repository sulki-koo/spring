package pubsub;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/pubsub")
public class PubSubServer {
    private static final Set<Session> clients = Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void onOpen(Session session) {
        clients.add(session);
        System.out.println("New subscriber connected: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session sender) {
        System.out.println("Message received: " + message);
        broadcastMessage(message);
    }

    @OnClose
    public void onClose(Session session) {
        clients.remove(session);
        System.out.println("Subscriber disconnected: " + session.getId());
    }

    private void broadcastMessage(String message) {
        synchronized (clients) {
            for (Session client : clients) {
                try {
                    client.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
