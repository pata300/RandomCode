import java.net.*;
import java.util.*;
// import java.util.concurrent.LinkedBlockingDeque;
// import java.util.concurrent.LinkedBlockingQueue;

//import jdk.internal.jline.internal.InputStreamReader;

import java.io.*;

public class Server {

    static Vector<ClientHandler> clientList = new Vector<>();

    static int clientCount = 0;

    public static void main(String args[]) throws IOException{
        ServerSocket myServer = new ServerSocket(5000);

        Socket socket;

        //infinite loop for client request
        while(true){
            //accept client request
            socket = myServer.accept();

            System.out.println("New client request received : " + socket);

            //get input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            System.out.println("Creating client handler");

            //Instantiate new handler object for request
            ClientHandler currentClient = new ClientHandler(socket, "client " + clientCount, input, output);

            //Instantiate a new Thread with the current client
            Thread thread = new Thread(currentClient);

            System.out.println("Adding current client to active client list");
            //add client to client list
            clientList.add(currentClient);

            //start the thread
            thread.start();

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

                System.out.println(received);

                if(received.equals("Bye")){
                    this.isLoggedIn = false;
                    this.socket.close();
                    break;
                }

                //seperate string into message and clients
                StringTokenizer strToken = new StringTokenizer(received, "#");
                String msgToSend = strToken.nextToken();
                String recipient = strToken.nextToken();

                //interate through recipients in client list
                for(ClientHandler clients: Server.clientList){
                    //if we find the client, we write to the output stream
                    if(clients.name.equals(recipient) && clients.isLoggedIn == true){
                        clients.dataOut.writeUTF(this.name + " : " + msgToSend);
                        break;
                    }
                }
            } catch(IOException e){
                e.printStackTrace();
            }
        }//end of while
        try{
            //close in stream and out stream
            this.dataIn.close();
            this.dataOut.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
    //private Socket socket = null;
    //private ServerSocket serverSocket;
    //private BufferedReader input = null;
    // private ArrayList<ConnectionToClient> clientList;
    // private LinkedBlockingQueue<Object> messages;

    // public Server (int port){
    //     clientList = new ArrayList<ConnectionToClient>();
    //     messages = new LinkedBlockingQueue<Object>();
    //     //serverSocket = new ServerSocket(port);

    //     System.out.println("Server Started");
        
    //     Thread accept = new Thread(){
    //         public void run(){
    //             while(true){
    //                 try{
    //                     serverSocket = new ServerSocket(port);
    //                     Socket s = serverSocket.accept();
    //                     System.out.println("Socket accepted");
    //                     clientList.add(new ConnectionToClient(s));
    //                 } catch(IOException e){
    //                     e.printStackTrace();
    //                 }
    //             }
    //         }
    //     };

    //     accept.setDaemon(true);
    //     accept.start();

    //     System.out.println(accept.getName());
        
    //     System.out.println("calling messageHandling");
    //     Thread messageHandling = new Thread() {
    //         public void run(){
    //             while(true){
    //                 try{
    //                     Object message = messages.take();
    //                     System.out.println("Message Received: " + message);
    //                 }
    //                 catch(InterruptedException e){
                    
    //                 }
    //             }
    //         }
    //     };

    //     messageHandling.setDaemon(true);
    //     messageHandling.start();
        

    //     //System.out.println("Server closing");
    
    // }

    // private class ConnectionToClient{
    //     ObjectInputStream in;
    //     ObjectOutputStream out;
    //     Socket socket;

    //     ConnectionToClient(Socket socekt) throws IOException {
    //         this.socket = socket;
    //         in = new ObjectInputStream(socket.getInputStream());
    //         out = new ObjectOutputStream(socket.getOutputStream());

    //         Thread read = new Thread(){
    //             public void run(){
    //                 while(true){
    //                     try{
    //                         Object obj = in.readObject();
    //                         messages.put(obj);
    //                     } catch(ClassNotFoundException e){
    //                         e.printStackTrace();
    //                     } catch(IOException e){
    //                         e.printStackTrace();
    //                     } catch(InterruptedException i){
    //                         i.printStackTrace();
    //                     }
    //                 }
    //             }
    //         };

    //         read.setDaemon(true);
    //         read.start();
    //     }
    

    //     public void write(Object obj){
    //         try{
    //             out.writeObject(obj);
    //         } catch(IOException e){
    //             e.printStackTrace();
    //         }
    //     }
    // }

    // public void sendToOne(int index, Object message) throws IndexOutOfBoundsException {
    //     clientList.get(index).write(message);
    // }

    // public void sendToAll(Object message){
    //     for(ConnectionToClient client : clientList)
    //         client.write(message);
    // }

        //try{
            
            // server = new ServerSocket(port);
            // input = new BufferedReader(new InputStreamReader(System.in));

            // System.out.println("Starting Server");

            // while(true){

            //     //instantiates socket
            //     socket = server.accept();


            //     //create a new thread
            //     ClientHandler clientSocket = new ClientHandler(socket);

            //     //thread handles socket seperately
            //     new Thread(clientSocket).start();

            // }

            
            //System.out.println("Client accepted");

            //input = new DataInputStream( new BufferedInputStream(socket.getInputStream()));

            //String line =  "";
            // while(!line.equals("over")){
            //     try{
            //         line = input.readUTF();
            //         System.out.println(line);
            //     } catch (IOException i ){
            //         System.out.println("Error " + i.getMessage());
            //         System.out.println(line);
            //     }
            // }
            // System.out.println("Closing connection...");
            // socket.close();
            // input.close();

            
        // } catch (Exception e){
        //     e.printStackTrace();
        // } 
        // finally{
        //     if(server != null){
        //         try{
        //             server.close();
        //         } catch(IOException e){
        //             e.printStackTrace();
        //         }
        //     }

        //     if(input != null){
        //         try{
        //             input.close();
        //         } catch(IOException e){
        //             e.printStackTrace();
        //         }
                
        //     }
        // }

    //}

    // private static class ClientHandler implements Runnable {
    //     private final Socket clientSocket;
    //     private String name = null;

    //     public ClientHandler(Socket socket){
    //         this.clientSocket = socket;
    //     }

    //     public void run(){
    //         PrintWriter out = null;
    //         BufferedReader in = null;

    //         try{
    //             out = new PrintWriter(
    //                 clientSocket.getOutputStream(), true
    //             );

    //             in = new BufferedReader(
    //                 new InputStreamReader(
    //                     clientSocket.getInputStream()
    //                 )
    //             );

    //             //System.out.println("Asking for username");

    //             out.println("Enter your username: ");
    //             //ask for username
    //             while(this.name == null){
    //                 this.name = in.readLine();
    //             }
    //             System.out.println("Welcome " + this.name);
    //             // this.name = in.readLine();

    //             out.println("Welcome " + this.name);

    //             String line;
    //             while((line = in.readLine()) != null){
    //                 System.out.println(this.name + ": " + line);
    //                 out.println(">"+ this.name + ": " + line);
    //                 out.println(line);
    //             }

    //         } catch(IOException e){
    //             e.printStackTrace();
    //         } finally{
    //             try{
    //                 if(out != null){
    //                     out.close();
    //                 }
    //                 if(in != null){
    //                     in.close();
    //                     clientSocket.close();
    //                 }
    //             } catch(IOException e){
    //                 e.printStackTrace();
    //             }
    //         }
    //     }

    // }

    
