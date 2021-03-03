import java.net.*;
import java.io.*;
import java.util.*;

public class Client {

    static int serverPort = 5000;
    public static void main(String args[]) throws UnknownHostException, IOException{
        Scanner scan = new Scanner(System.in);
        Socket socket;

        try{
            InetAddress ip = InetAddress.getByName(args[0]);
            serverPort = Integer.parseInt(args[1]);
            //establish the connection
            socket = new Socket(ip, serverPort);
            //System.out.println("command line args used");
        } catch(UnknownHostException e){
            System.out.println("Not a valid hostname");
            //get ip address
            InetAddress ip = InetAddress.getByName("localhost");

            //establish the connection
            socket = new Socket(ip, 5000);

            System.out.println("catch socket was established instead");
        } catch(ConnectException e){
            System.out.println("Not a valid port number");
            //get ip address
            InetAddress ip = InetAddress.getByName(args[0]);

            //establish the connection
            socket = new Socket(ip, 5000);
        }

        

        //get input and output streams
        DataInputStream dataIn = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());

        System.out.println("Enter a username: ");
        String name = scan.nextLine();
        dataOut.writeUTF(name);

        //create sendMessage thread
        Thread sendMessage = new Thread(new Runnable(){
            @Override
            public void run(){
                //System.out.println("send message thread is running");
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
        
        Thread readMessage = new Thread(new Runnable(){
            @Override
            public void run(){
                Boolean isRunning = true;
                while(isRunning){
                    //System.out.println("read message thread is running");
                    try{
                        //read the message sent to this client
                        String msg = dataIn.readUTF();
                        if(msg == "Bye") {
                            isRunning = false;
                            break;
                        } else
                            System.out.println(msg);
                        //dataIn.flush();
                        //System.out.println("Wrote message " + msg);
                    } catch(IOException e){
                        //System.out.println("client readMessage catch");
                        isRunning = false;
                        //e.printStackTrace();
                    } 
                }
            }
        });

        sendMessage.start();
        readMessage.start();
    }
  