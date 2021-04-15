import java.net.*;
import java.util.*;
import java.io.*;

public class Game {
	 static ArrayList<PlayerHandler> playerList = new ArrayList<>();

	 static int clientCount = 0;
	 static Boolean gameOver = false;
	 public enum Players {PLAYER1, PLAYER2}
	 static Players currentPlayer;

	    
	    public static void main(String args[]) throws IOException{
	        //create server socket broadcasting on port 5000
	        ServerSocket myServer = new ServerSocket(5000);

	        Socket socket = null;

	        System.out.println("Starting server...");

	        //while less than 2 players, loop for client request
	        while(playerList.size() < 2){
	            //if(playerList.size() < 2) {
	            	//accept client request
		            socket = myServer.accept();
	            //}

	            System.out.println("New player request received : " + socket);

	            //get input and output streams
	            DataInputStream input = new DataInputStream(socket.getInputStream());
	            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

	            System.out.println("Creating client handler");
	            
	            String name = input.readUTF();
	            System.out.println("Welcome to the game " + name);
	            
	            String msg = null;
	            ArrayList<String> shipCoordinates = new ArrayList<String>();
	            
	            //once player has set ships on board they can be added to the player list
	            	System.out.println("Waiting for coordinates");

	            	//get ship coordinates from player
	    	        //*** may cause errors, might have to check for players when inputing
	    	        for(int i = 0; i < 9; i++) {
	            		try {
	            			msg = input.readUTF();
	            			System.out.println("Adding " + msg + " to coordinates.");
	            			shipCoordinates.add(msg);
	            		} catch(IOException e) {
	            			System.out.println("Error sending player ship coordinates to server");
	            		}
	            	}
	            	
	            System.out.println("Creating PlayerHandler");
	            PlayerHandler currentClient = null;

	            if(playerList.size() == 0) {
	            	//Instantiate player 1 object for request
		            currentClient = new PlayerHandler(socket, name, input, output, Players.PLAYER1, shipCoordinates);
	            } else if(playerList.size() == 1) {
	            	//Instantiate player 2 object for request
		            currentClient = new PlayerHandler(socket, name, input, output, Players.PLAYER2, shipCoordinates);
	            }

	            //Instantiate a new Thread with the current client
	            Thread thread = new Thread(currentClient);

	            //add client to client list
	            playerList.add(currentClient);

	            //start the thread
	            thread.start();

	            //add players to player list
	            if(playerList.size() == 2)
	            for(int i = 0; i < playerList.size(); i++){
	                    PlayerHandler temp = Game.playerList.get(i);  
	                    temp.dataOut.writeUTF("ready");
	            } 
	            
	        }
	        //picker player to start game
	        System.out.println("The current player has been choosen.");
	        currentPlayer = Players.PLAYER1;
	        playerList.get(0).dataOut.writeUTF("It is currently your turn.");
	        
	    }
	    

	}

	/**
	 * 
	 * @author pata
	 *	PlayerHandler is giving the player sockets and handles multithreaded communications between clients
	 */
	class PlayerHandler implements Runnable {
	    Scanner scan = new Scanner(System.in);
	    private String name;
	    final DataInputStream dataIn;
	    final DataOutputStream dataOut;
	    Socket socket;
	    boolean gameOver = false;
	    boolean miss = true;
	    Game.Players player;
	    ArrayList<String> shipCoordinates;
	    
	    /**
	     * 
	     * @param socket		the socket which the client is connected to
	     * @param name			name of the client
	     * @param dataIn		InputStream of the client
	     * @param dataOut		OutputStream of the client
	     * @param player		Player enum that is assigned to this client
	     * @param shipCoordinates	list of ship coordinates associated with the client
	     */
	    public PlayerHandler(Socket socket, String name, DataInputStream dataIn, DataOutputStream dataOut, Game.Players player, ArrayList<String> shipCoordinates){
	        this.dataIn = dataIn;
	        this.dataOut = dataOut;
	        this.name = name;
	        this.socket = socket;
	        this.player = player;
	        this.shipCoordinates = shipCoordinates;
	        	
	    }

	   
	    @Override
	    public void run(){
	        String received;
	        
	        //start game loop
	        while(!gameOver){
	            		            
	        	try{
	                received = dataIn.readUTF();
	                received = received.toUpperCase();
	                
	                miss = true;
	                //only the current player can send coordinates, all other input is ignored by the server
	                if(Game.currentPlayer == this.player) {
	                	for(PlayerHandler c : Game.playerList) {
            				c.dataOut.writeUTF(this.player + " fires torpedo to coordinate " + received);
            				
            				if(Game.currentPlayer != c.player) {
            					//check the coordinate against the player's ship coordinates
        	                	for(int i = 0; i < c.shipCoordinates.size(); i++) {
        	                		//if we get a match > hit

        	                		if(c.shipCoordinates.get(i).equals(received)) {
        	                			c.shipCoordinates.remove(i);
        	                			
        	                			miss = false;
        	                			
        	                			//hit flag for player class
        	                			if(this.player == Game.Players.PLAYER1) {
        	                				Game.playerList.get(1).dataOut.writeUTF("HIT" + received); //inform player that has been hit
        	                				Game.playerList.get(0).dataOut.writeUTF("SET_TO_RADAR" + received); //inform player that hit their opponent to mark it on the radar
        	                			} else {
        	                				Game.playerList.get(0).dataOut.writeUTF("HIT" + received);
        	                				Game.playerList.get(1).dataOut.writeUTF("SET_TO_RADAR" + received);
        	                			}
        	                			
        	                			for(PlayerHandler p : Game.playerList) {
        	                				p.dataOut.writeUTF("PRINT_BOARD");
        	                				p.dataOut.writeUTF("BOOOM!! " + this.name + " got a hit.");	                				
        	                			}
        	                				
        	                			//check for game over
        	                			if(c.shipCoordinates.isEmpty())
        	                				gameOver = true;
        	                		}
        	                		
        	                	}
            				}
            			}
	                	
	                	if(miss) {
	                		//if miss. Players are informed and player that miss has their board updated with an M
		                	for(PlayerHandler c : Game.playerList) {
	            				c.dataOut.writeUTF("SPLOOOSH!! Better luck next time, " + this.name);
	            				if(Game.currentPlayer == c.player)
	            					c.dataOut.writeUTF("MISS" + received);
	            				c.dataOut.writeUTF("PRINT_BOARD");
	            			}
	                	}
	                	
	                	//informing player that is not currently picking the coordinates to chill
	                } else if(this.player == Game.Players.PLAYER1){
	                	Game.playerList.get(0).dataOut.writeUTF("It is not currently your turn. Please wait.");
	                } else if(this.player == Game.Players.PLAYER2) {
	                	Game.playerList.get(1).dataOut.writeUTF("It is not currently your turn. Please wait.");
	                }
	                
	              //change player
	                if(this.player == Game.Players.PLAYER1){
	                	Game.currentPlayer = Game.Players.PLAYER2;
	                	Game.playerList.get(1).dataOut.writeUTF("It is currently your turn.");
	                } else if(this.player == Game.Players.PLAYER2) {
	                	Game.currentPlayer = Game.Players.PLAYER1;
	                	Game.playerList.get(0).dataOut.writeUTF("It is currently your turn.");
	                }


	            } catch(IOException e){
	                System.out.println("server PlayerHandler while loop catch");
	                e.printStackTrace();
	            } 
	            //}//end of player loop
	        	
	        }//end of game loop
	        
	        //send game over flag to player clients
	        try {
	        	for(PlayerHandler c : Game.playerList) {
					c.dataOut.writeUTF("GAMEOVER");
					if(c.shipCoordinates.isEmpty())
						c.dataOut.writeUTF("LOSER");
					else
						c.dataOut.writeUTF("WINNER");
				}
	        } catch(IOException e) {
	        	System.out.println("GAME OVER");
	        }
	        
	        
	        try{
	            //close in stream and out stream
	            this.dataIn.close();
	            this.dataOut.close();
	        } catch(IOException e){
	            System.out.println("server PlayerHandler final catch");
	            e.printStackTrace();
	        }
	    }
	    
}
