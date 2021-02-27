import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

//import jdk.internal.jshell.tool.MessageHandler;

public class Client {

    final static int serverPort = 5000;
    public static void main(String args[]) throws UnknownHostException, IOException{
        Scanner scan = new Scanner(System.in);

        //get ip address
        InetAddress ip = InetAddress.getByName("localhost");

        //establish the connection
        Socket socket = new Client(ip, serverPort);

        //get input and output streams
        DataInputStream dataIn = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());

        //create sendMessage thread
        Thread sendMessage = new Thread(new Runnable(){
            @Override
            public void run(){
                while(true){
                    //read the message to deliver
                    String msg = scan.nextLine();

                    try{
                        //write to the output stream
                        dataOut.writeUTF(msg);
                    } catch(IOException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        
    }
    // private Socket socket = null;
    // // private BufferedReader input = null;
    // // //private InputStream in = null;
    // // private PrintWriter out = null;
    // private ConnectionToServer server;
    // private LinkedBlockingQueue<Object> messages;

    // public Client(String address, int port) throws IOException {
    //     socket = new Socket(address, port);
    //     messages = new LinkedBlockingQueue<Object>();
    //     server = new ConnectionToServer(socket);

    //     System.out.println("Starting client");

    //     Thread messageHandling = new Thread() {
    //         public void run(){
    //             while(true){
    //                 try{
    //                     Object message = messages.take();
    //                     System.out.println("Message Received: " + message);
    //                 } catch (InterruptedException e){

    //                 }
    //             }
    //         }
    //     };

    //     messageHandling.setDaemon(true);
    //     messageHandling.start();
    // }

    // private class ConnectionToServer{
    //     ObjectInputStream in;
    //     ObjectOutputStream out;
    //     Socket socket;

    //     ConnectionToServer(Socket socket) throws IOException {
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

    //     private void write(Object obj){
    //         try{
    //             out.writeObject(obj);
    //         } catch(IOException e){
    //             e.printStackTrace();
    //         }
    //     }
    // }

    // public void send(Object obj){
    //     server.write(obj);
    // }
        // try{
        //     socket = new Socket(address, port);
        //     System.out.println("Connected");
        //     input = new BufferedReader(new InputStreamReader(
        //         socket.getInputStream()
        //     ));

        //     out = new PrintWriter(
        //         socket.getOutputStream(), true);
        // } catch (Exception e){
        //     System.out.println("error " + e.getMessage());
        // }

        // Scanner scan = new Scanner(System.in);
        // //System.out.println("Server : " + input.readLine());

        // String line = "";
        // while(!"Bye".equalsIgnoreCase(line)){
        //     try{
        //         System.out.println("Server : " + input.readLine());
        //         line = scan.nextLine();
        //         //System.out.println("Server : " + input.readLine());

        //         out.println(line);
        //         out.flush();

                

        //     } catch  (IOException i){
        //         System.out.println(i);
        //     }
        // }

        // try{
        //     input.close();
        //     out.close();
        //     socket.close();
        // } catch  (IOException i ){
        //     System.out.println(i);
        // }
    //}

    
}