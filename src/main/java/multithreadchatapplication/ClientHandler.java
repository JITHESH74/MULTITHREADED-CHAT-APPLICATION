package multithreadchatapplication;
import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler implements Runnable{

    private Socket socket;
    private Set<Socket> clients;

    // Constructor to initialize the socket and shared client list
    public ClientHandler (Socket socket, Set<Socket> clients){
        this.socket = socket;
        this.clients = clients;
    }
    public void run(){
        try(

                //input stream to read messages from this client
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                //output stream to send messages to this client
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        ){

            //send a welcome message to this client who just connected
            writer.println("Welcome to the chat");

            String msg;

            //continuously read message from this client
            while((msg = reader.readLine()) != null){
                System.out.println("Received " + msg);

                //broadcast to all clients
                for(Socket client : clients){
                    if(client != socket){
                        new PrintWriter(client.getOutputStream(), true).println("client :" + msg);
                    }
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }finally{

            // When the client disconnects or error occurs, clean up
            try{
                clients.remove(socket); // Remove this client's socket from the shared list
                socket.close(); //close the socket connection
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
}
