package multithreadchatapplication;
import java.util.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Server {

    //port number where the server listen for the incoming connections
    private static final int PORT = 1234;

    // A thread-safe set to keep track of all connected client sockets
    // Collections.synchronizedSet ensures safe access across threads
    private static Set<Socket> clientSockets = Collections.synchronizedSet(new HashSet<>());


    public static void main(String[] args){
        try(ServerSocket serverSockets = new ServerSocket(PORT)){
            System.out.println("Server started waiting for clients");

            // Run an infinite loop to accept incoming client connection
            while(true){

                //accept a new client connection
                Socket clientSocket = serverSockets.accept();

                // Add the client socket to the shared set for broadcasting
                clientSockets.add(clientSocket);
                System.out.println("client connected " + clientSocket);

                // Start a new thread to handle communication with this client
                // The thread runs an instance of ClientHandler
                new Thread(new ClientHandler(clientSocket,clientSockets)).start();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
