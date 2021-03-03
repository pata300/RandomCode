import java.net.*;
import java.util.*;
import java.io.*;

public class Server {

    static ArrayList<ClientHandler> clientList = new ArrayList<>();

    static int clientCount = 0;

    public static void main(String args[]) throws IOException{
        //create server socket broadcasting on port 5000
        ServerSocket myServer = new ServerSocket(5000);

        Socket socket;

        System.out.println("Starting server...");

        //infinite loop for client request
        while(true){
            //accept client request
            socket = myServer.accept();

            System.out.println("New client request received : " + socket);

            //get input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            System.out.println("Creating client handler");
            //myServer.writeUTF("Enter a username: ");

            //output.writeUTF("Enter a username: ");
            String name = input.readUTF();

            //Instantiate new handler object for request
            ClientHandler currentClient = new ClientHandler(socket, name, input, output);

            //Instantiate a new Thread with the current client
            Thread thread = new Thread(currentClient);

            System.out.println("Welcome " + name);
            //add client to client list
            clientList.add(currentClient);

            //start the thread
            thread.start();

            for(int i = 0; i < clientList.size(); i++){
                if(Server.clientList.get(i).isLoggedIn){
                    ClientHandler temp = Server.clientList.get(i);  
                    temp.dataOut.writeUTF("Welcome " + name);
                }
            } 

            //increment client count
            clientCount++;
        }
    }

}



class ClientHandler implements Runnable {
    Scanner scan = new Scanner(System.in);
    private String name;
    final DataInputStream dataIn;
    final DataOutputStream dataOut;
    Socket socket;
    boolean isLoggedIn;

    public ClientHandler(Socket socket, String name, DataInputStream dataIn, DataOutputStream dataOut){
        this.dataIn = dataIn;
        this.dataOut = dataOut;
        this.name = name;
        this.socket = socket;
        this.isLoggedIn = true;
    }

    @Override
    public void run(){
        String received;
        while(true){
            try{
                received = dataIn.readUTF();

                if(received.equals("Bye")){
                    this.isLoggedIn = false;
                    System.out.println("Server: Goodbye " + this.name);
                    for(int i = 0; i < Server.clientList.size(); i++){
                        //if we find the client, we write to the output stream
                        if(Server.clientList.get(i).isLoggedIn){
                            ClientHandler temp = Server.clientList.get(i);
                            temp.dataOut.writeUTF("Server: Goodbye " + this.name);
                        }
                            //break;
                        //}
                    } 
                    this.socket.close();
                    
                    
                    break;
                }

                System.out.println(this.name + ": " + received);

                //interate through recipients in client list
                for(int i = 0; i < Server.clientList.size(); i++){
                    //if we find the client, we write to the output stream
                    if(Server.clientList.get(i).isLoggedIn){
                        ClientHandler temp = Server.clientList.get(i);
                        temp.dataOut.writeUTF(this.name + ": " + received);
                    }
                        //break;
                    //}
                } 
                //System.out.println("end of server loop");
            } catch(IOException e){
                System.out.println("server clientHandler while loop catch");
                e.printStackTrace();
            } 
        }//end of while
        try{
            //close in stream and out stream
            this.dataIn.close();
            this.dataOut.close();
        } catch(IOException e){
            System.out.println("server clientHandler final catch");
            e.printStackTrace();
        }
    }
}

    
