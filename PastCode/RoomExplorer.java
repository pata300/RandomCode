/*

	Homework 5
	1583
	P. Griffin

	Notes:	This program has all the requirements of the homework with a bonus component worked in.
			At the beginning of the game a ghost is brought into the map/house,
			and chases the player around. There is no win condition against the computer
			but if the computer/ghost does end up in the same room as the player it is game over.


*/

import java.util.Scanner;
import java.util.Random;

public class RoomExplorer{
 
 	static final int NUMBER_OF_ROOMS = 7;

	static final int NORTH = 0;
 	static final int EAST = 1;
 	static final int WEST = 2;
 	static final int SOUTH = 3;

	// 1. Array for	String	data (Room	Descriptions)
 	static String[] roomDescription = {"You are in the Guest Bedroom,\nexits are north and east.", 
 		"You are in the South Hall,\nexits are north, east, and west.",
		"You are in the Dining Room,\nexits are north and west.",
		"You are in the Master Bedroom,\nexits are east, and south.",
		"You are in the North Hall,\nexits are north, east, west, and south.",
		"You are in the Kitchen,\nexits are west and south.",
		"You are in the Balcony,\nexits are south."};
 	
	// 2. Multidimensional	array for	integer	data (Room	Exits)
 	static int[][] roomExit = new int[NUMBER_OF_ROOMS][4];

 	public static void main(String[] args){

	 	Random rand = new Random();

	 	int currentRoom = 0;
	 	boolean exploring = true;
	 	char userDirection;

	 	int compLocation = 0;

	 	//roomDescription[0] = "You are in the Guest Bedroom,\nexits are north and east.";
		// roomDescription[1] = "You are in the South Hall,\nexits are north, east, and west."; 
		// roomDescription[2] = "You are in the Dining Room,\nexits are north and west.";
		// roomDescription[3] = "You are in the Master Bedroom,\nexits are east, and south.";
		// roomDescription[4] = "You are in the North Hall,\nexits are north, east, west, and south.";
		// roomDescription[5] = "You are in the Kitchen,\nexits are west and south.";
		// roomDescription[6] = "You are in the Balcony,\nexits are south.";

		roomExit[0][0] = 3;
		roomExit[0][1] = 1;
		roomExit[0][2] = -1;
		roomExit[0][3] = -1;

		roomExit[1][0] = 4;
		roomExit[1][1] = 2;
		roomExit[1][2] = 0;
		roomExit[1][3] = -1;

		roomExit[2][0] = 5;
		roomExit[2][1] = -1;
		roomExit[2][2] = 1;
		roomExit[2][3] = -1;

		roomExit[3][0] = -1;
		roomExit[3][1] = 4;
		roomExit[3][2] = -1;
		roomExit[3][3] = 0;

		roomExit[4][0] = 6;
		roomExit[4][1] = 5;
		roomExit[4][2] = 3;
		roomExit[4][3] = 1;

		roomExit[5][0] = -1;
		roomExit[5][1] = -1;
		roomExit[5][2] = 4;
		roomExit[5][3] = 2;

		roomExit[6][0] = -1;
		roomExit[6][1] = -1;
		roomExit[6][2] = -1;
		roomExit[6][3] = 4;

		//quick opener and rules for user
		System.out.println("\n\n**** WELCOME TO THE GAME ****\n");
		System.out.println("\nYou walk into a spoOoOoky house.");
		System.out.println("You quickly discover you're being chased by a g-g-g-g-ghoOoOoOost!!!");
		System.out.println("\nRULES:  DO NOT GET CAUGHT BY THE GHOST." +
								"\n\tIF YOU END UP IN THE SAME ROOM AS THE POLTERGEIST" +
								"\n\tIT WILL STEAL YOUR SOOOOUL!!!!\n");

		// 8. Repetition Statement(Game loop)
	 	while(exploring){

	 		//System.out.println(roomExit[0][0]);

	 		printDescription(currentRoom);
	 		userDirection = getDirection();

	 		// 9. Selection	Statement	(Execute	the	player’s	choice)
	 		if(userDirection == 'q'){

	 			exploring = false;
	 			System.out.println("You decided you're done playing with the ghost.");
	 			System.out.println("You pull off it's mask and discover its just old man Jinkers.");
	 			System.out.println("He starts to yell at you about a dog or something... but you've already left.");
	 			System.out.println("Thanks for playing!");

	 		} else if (userDirection == 'n') {

	 			currentRoom = checkDirection(currentRoom, NORTH);

	 		} else if (userDirection == 's') {

	 			currentRoom = checkDirection(currentRoom, SOUTH);

	 		} else if (userDirection == 'w') {

	 			currentRoom = checkDirection(currentRoom, WEST);
	 			
	 		} else if (userDirection == 'e') {

	 			currentRoom = checkDirection(currentRoom, EAST);
	 			
	 		} else {

	 			System.out.println("Your input was invalid, try again.");

	 		}

		 	if(exploring == true){

		 		//AI version of the player's game loop
		 		int compDirection = rand.nextInt(4);
		 		
		 		compLocation = checkCompDirection(compLocation, compDirection);
		 		printCompLocation(compLocation);

		 	}

		 	if(currentRoom == compLocation){

		 		exploring = false;

		 		System.out.println("Uh-oh... The ghost gotcha!!");
		 		System.out.println("Better luck next time.");
		 		System.out.println("GAME OVER");

		 	}

	 	}

 	}//end of main()

 	static void printDescription(int currentRoom){

 		//print room descriptions
 		System.out.println("*********** PLAYER LOCATION ***********");
 		System.out.println(roomDescription[currentRoom]);
 		System.out.println("***************************************");
 		System.out.println("Please input: n for north, s for south, w for west, e for east, or q to quit");

 	}

 	//prints the computer's information to the user
 	static void printCompLocation(int currentRoom){

 		String[] roomName = {	"Guest Bedroom",
 								"South Hall",
 								"Dining Room",
 								"Master Bedroom",
 								"North Hall",
 								"Kitchen",
 								"Balcony"
 							};

 		//print room descriptions
 		System.out.println("*********** GHOST LOCATION ***********");
 		System.out.println(roomName[currentRoom]);
 		System.out.println("***************************************");
 		
 	}

 	static char getDirection(){

 		Scanner input = new Scanner(System.in);
 		char userDirection = 'q';

	 	//user is asked to input specific characters
	 	//only the first character of the line is assigned to the variable
	 	//the char is then parsed to a lower case letter and compared to the 
	 	//possible valid inputs, if it does not match an exception is thrown,
	 	//the user is informed and prompted again for a valid choice	
 		try {

 			System.out.println("\n******************************************");
 			System.out.print("Which direction would you like to travel? ");
 			userDirection = input.nextLine().charAt(0);
 			userDirection = Character.toLowerCase(userDirection);
 			System.out.println();

 			if(userDirection != 'n' || userDirection != 'w'
 				|| userDirection != 'e' || userDirection != 's'
 				|| userDirection != 'q'){

 				new Exception();
 			}

 		} catch (Exception exception) {

 			System.out.println("Not a valid input. Try again.");
 			System.out.println("*****************************\n");

 		}

 		return userDirection;

 	}

 	static int checkDirection(int currentRoom, int direction){

 		//argument is one of the direction constants
 		//check the reference of roomExit[currentRoom][direction]

 		if(roomExit[currentRoom][direction] != -1){

 			currentRoom = roomExit[currentRoom][direction];

 		} else { System.out.println("There is no exit in that direction."); }

 		return currentRoom;

 	}

 	//checks AI's movements; unlike user movement, the ghost can stay in a single spot
 	static int checkCompDirection(int currentRoom, int direction){

 		if(roomExit[currentRoom][direction] != -1){

 			currentRoom = roomExit[currentRoom][direction];

 		} else { System.out.println("The ghost has not moved."); }

 		return currentRoom;

 	}
} //end of class