

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

class Player {
	
    static int serverPort = 5000;
    static Board playerBoard;
    static boolean gameOver = false;
    
    public static void main(String args[]) throws UnknownHostException, IOException{
        Scanner scan = new Scanner(System.in);
        Socket socket;
        

        try{
//            InetAddress ip = InetAddress.getByName(args[0]);
//            serverPort = Integer.parseInt(args[1]);
//            //establish the connection
//            socket = new Socket(ip, serverPort);
//            //System.out.println("command line args used");
//        } catch(UnknownHostException e){
            //System.out.println("Not a valid hostname");
            //get ip address
            InetAddress ip = InetAddress.getByName("localhost");

            //establish the connection
            socket = new Socket(ip, 5000);

            //System.out.println("catch socket was established instead");
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
        
        //creates a board for the player
        playerBoard = new Board();
        //ask the player to set ships on their board
    	playerBoard.setShips();
    	
    	//send ship info to server
    	Ship temp = playerBoard.smallShip;
    	for(int i = 0; i < 3; i++) {
    		
        	for(String coord : temp.getCoordinates()) {
        		 try{
                     //write to the output stream
                     dataOut.writeUTF(coord);
                 } catch(IOException e){
                     e.printStackTrace();
                 }
        	}
        	if(i == 0)
        		temp = playerBoard.mediumShip;
        	else if(i == 1)
        		temp = playerBoard.largeShip;
    	}
    	
    	System.out.println(playerBoard);
    	System.out.println("Please Wait for other player...");
    	
    	//waits for ready message from server
    	String msg;
    	boolean ready = false;
    	while(!ready) {
    		msg = dataIn.readUTF();
    		if(msg.equals("ready"))
    			ready = true;
    	}
    	

        //create sendMessage thread
        Thread sendMessage = new Thread(new Runnable(){
            @Override
            public void run(){
                //reads player's coordinate inputs
            	boolean validInput;
                //while the game isn't over
            	while(!gameOver){
                    //read the message to deliver
                	String playerChoice = null;
                	validInput = false;
                    //take player coordinates, check if valid
                	while(!validInput) {
                    	playerChoice = scan.nextLine();
                    	validInput = playerBoard.checkInput(playerChoice.toUpperCase());
                    	if(!validInput)
                    		System.out.println("Invalid input. Pick a coodinate from the board.");
                    }
                		
                    try{
                        //write to the output stream
                        dataOut.writeUTF(playerChoice);
                    } catch(IOException e){
                        e.printStackTrace();
                    }
                    System.out.println(playerBoard.toString());
                }
                
            }
        });
        
        //create readMessage thread
        Thread readMessage = new Thread(new Runnable(){
            @Override
            public void run(){
                //while the game isn't over
                while(!gameOver){
                	
                    try{
                        //read the message sent to this client
                        String msg = dataIn.readUTF();
                        
                        if(msg.length() > 3 && msg.substring(0, 3).equals("HIT")) {
                            //player took a hit. Update the ship that was hit.
                        	//check the rest of the string for the coordinate to update/remove
                        	playerBoard.updateShips(msg.substring(3));
                            
                        } else if(msg.equals("GAMEOVER")){
                        	//end of game, close socket
                        	gameOver = true;
                        	System.out.println("Game over!");
                        	msg = dataIn.readUTF();
                        	if(msg.equals("WINNER"))
                        		System.out.println(name + " is the winner!!");
                        	else
                        		System.out.println(name + " is the loser...");
                        } else if(msg.length() > 12 && msg.substring(0, 12).equals("SET_TO_RADAR")) {
                        	//updates board where the hit took place
                        	playerBoard.updateBoard(msg.substring(12));
                        } else if(msg.equals("PRINT_BOARD")) {
                        	//informs player client to print board
                        	System.out.println(playerBoard);
                        } else if(msg.length() > 4 && msg.substring(0, 4).equals("MISS")) {
                        	//updates board where the miss occured
                        	playerBoard.updateMiss(msg.substring(4));
                        } else
                            System.out.println(msg);
                        
                    } catch(IOException e){
                        System.out.println("client readMessage catch");
                        
                    } 
                }
                
            }
        });
        
        System.out.println("Let's begin.");

        sendMessage.start();
        readMessage.start();
        
        while(true) {
        	if(gameOver) {
        		try {
                	dataIn.close();
                	dataOut.close();
                	socket.close();
                	scan.close();
                } catch(IOException e) {
                	System.out.println("Could not close player client.");
                }
        	}
        }
    }
	
}
