package multithreadchatapplication;
import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args){
        try(
                //create a socket to connect to the server running on localhost at port 1234
        Socket socket = new Socket("localhost",1234);

        //reader to take input from the user via console
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //ready to receive the message from the server
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //writer to send message to the server
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ){
            System.out.println("connected to the server");

            //Read messages from the server in a new thread
            new Thread(() -> {
                String serverMsg;
                try{
                    while((serverMsg = in.readLine()) != null){
                        System.out.println(serverMsg);
                    }
                    }catch(IOException e){
                    e.printStackTrace();  //print error if reading fails
                }
            }).start();

            //send user input to server
            String userMsg;
            while((userMsg = reader.readLine()) != null){
              out.println(userMsg);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
