package multithreadchatapplication;
import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args){
        try(
        Socket socket = new Socket("localhost",1234);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
                    e.printStackTrace();
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
