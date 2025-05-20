package multithreadchatapplication;
import java.util.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Server {

    private static final int PORT = 1234;
    private static Set<Socket> clientSockets = Collections.synchronizedSet(new HashSet<>());


    public static void main(String[] args){
        try(ServerSocket serverSockets = new ServerSocket(PORT)){
            System.out.println("Server started waiting for clients");

            while(true){
                Socket clientSocket = serverSockets.accept();
                clientSockets.add(clientSocket);
                System.out.println("client connected " + clientSocket);
                new Thread(new ClientHandler(clientSocket,clientSockets)).start();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
