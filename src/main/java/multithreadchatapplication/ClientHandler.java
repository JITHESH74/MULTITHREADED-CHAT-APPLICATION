package multithreadchatapplication;
import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler implements Runnable{

    private Socket socket;
    private Set<Socket> clients;

    public ClientHandler (Socket socket, Set<Socket> clients){
        this.socket = socket;
        this.clients = clients;
    }
    public void run(){
        try(
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        ){
            writer.println("Welcome to the chat");

            String msg;
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
            try{
                clients.remove(socket);
                socket.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
}
