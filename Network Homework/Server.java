import java.net.*;
import java.io.*;

public class Server {
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream input = null;

    public Server (int port){
        try{
            
            server = new ServerSocket(port);

            System.out.println("Starting Server");
            System.out.println("Waiting for client");

            socket = server.accept();

            System.out.println("Client accepted");

            input = new DataInputStream( new BufferedInputStream(socket.getInputStream()));

            String line =  "";
            while(!line.equals("over")){
                try{
                    line = input.readUTF();
                    System.out.println(line);
                } catch (IOException i ){
                    System.out.println("Error " + i.getMessage());
                    System.out.println(line);
                }
            }

            System.out.println("Closing connection...");
            socket.close();
            input.close();
        } catch (Exception e){
            System.out.println("Error here " + e.getMessage());
        }

    }

    public static void main(String args[]){
        Server myServer = new Server(5000);
    }
}