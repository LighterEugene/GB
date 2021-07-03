import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public ChatServer(){
        ServerSocket serv = null;
        Socket sock = null;
        try {
            serv = new ServerSocket(8189);
            System.out.println("Сервер запущен, ожидаем подключения...");
            sock = serv.accept(); // Искомый ждёт пока кто-либо не захочет подсоединится к нему, и когда это происходит
            // возвращает объект типа Socket, то есть воссозданный клиентский сокет. И вот когда сокет клиента создан на
            // стороне сервера, можно начинать двухстороннее общение.
            System.out.println("Клиент подключился");
            new Client(sock, "Сервер");
            while(true){
                if(sock.isClosed()){
                    break;
                }
            }
            serv.close();// закрытие сокета
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Ошибка инициализации сервера");
        } finally {
            try {
                serv.close();// закрытие сокета
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new ChatServer();
    }
}