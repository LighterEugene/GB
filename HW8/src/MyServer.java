

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class MyServer {
    private static final long MAX_DELAY_TIME = 120;
    private final List<ClientHandler> clients = Collections.synchronizedList(new ArrayList<>());
    private isConnect isConnect;

    public static void main(String[] args) {
        new MyServer(new BaseAuthService());
    }

    private MyServer(isConnect isConnect) {
        this.isConnect = isConnect;

        Socket s = null;
        ServerSocket server = null;
        try {
            server = new ServerSocket(8189);
            System.out.println("Server created. Waiting for client...");


            while (true) {

                s = server.accept();

                ClientHandler client = new ClientHandler(this, s);
               // System.out.println(" Идёт подключение клиента...");
                client.start();
                startKiller();
                clients.add(client);



            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
                System.out.println("Server closed");
                if (s != null) s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void startKiller() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    LocalDateTime now = LocalDateTime.now();

                    Iterator<ClientHandler> i = clients.iterator();
                    while (i.hasNext()) {
                        ClientHandler client = i.next();
                       // client.setAuth(false);
                        if (client.isCheckAuthForDisconnection == false
                                && Duration.between(client.getConnectTime(), now).getSeconds() > MAX_DELAY_TIME) {
                            System.out.println("close unauthorized user");
                            client.close();
                            i.remove();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    isConnect getAuthService() {
        return isConnect;
    }

    void sendBroadcastMessage(String msg) {
        for (ClientHandler c : clients) {
            if (c.isActive()) c.sendMessage(msg);
        }
    }

    void sendPrivateMessage(String from, String userName, String message) {
        for (ClientHandler c : clients) {
            String name = c.getHandlerName();
            if (name.equals(userName) && c.isActive())
                c.sendMessage(from + " написал лично " + userName + ": " + message);
        }
    }
}