/*
	
	Patrick Griffin
	Lab 3
	Problem 4: Player Move Overworld

*/

import java.util.Scanner;

public class PlayerMoveOverworld{

	public static void main(String[] args){

		int x;
		int y;
		//keep track of our coordinates on the overworld map

		int testCase;
		//this will dictate how may loops the for loop does
		int stringLength;

		String playerMove;
		char currentChar;
		//String currentChar;
		//strings for all possible direction inputs
		String w = "w";
		String a = "a";
		String s = "s";
		String d = "d";
		//String newLine = "";

		boolean moveOver = false;

		int j = 0;

		Scanner input = new Scanner(System.in);

		testCase = input.nextInt();

		for(int i = 0; i < testCase; i++){

			//ask user for the coordinates to start at
			x = input.nextInt();
			y = input.nextInt();

			//System.out.println(x + ", " + y);

			input.nextLine();
			playerMove = input.nextLine();
			//playerMove = input.next();

			//System.out.println(playerMove);
			//playerMove = "\n";
			//gets the direction the player wants to move
			stringLength = playerMove.length();

			//System.out.println("the string is " + stringLength);

			// if(playerMove.equals(w)){

			// 			//decrease y by 1
			// 	y--;

			// } else if(playerMove.equals(a)){

			// 	//decrement x by one
			// 	x--;

			// } else if(playerMove.equals(s)){

			// 	//increment y by 1
			// 	y++;

			// } else if(playerMove.equals(d)) {

			// 	//only valid command left would increment x by 1
			// 	x++;

			// }

				//moveOver = playerMove.hasNext();

			for(j = 0; j < playerMove.length(); j++){
			//while(j < stringLength){

				currentChar = playerMove.charAt(j);
				//currentChar = playerMove.toCharArray();
				//j++;
				//currentChar = input.next(playerMove);

				//System.out.println(playerMove.length());

				//System.out.println(currentChar + " is the current move.");
				//System.out.println(playerMove.length());

				// if(playerMove.equals(newLine)){

				// 	System.out.println("new line is " + playerMove.equals(newLine));
				
				// }

				if(currentChar == 'w'){

					y--;

				} else if(currentChar == 'a'){

					x--;

				} else if(currentChar == 's'){

					y++;

				} else if(currentChar == 'd'){

					x++;

				}

				//huge multi-selection if/else loop to move the player
				// if(currentChar.equals(w)){

				// 	//decrease y by 1
				// 	y--;

				// } else if(currentChar.equals(a)){

				// 	//decrement x by one
				// 	x--;

				// } else if(currentChar.equals(s)){

				// 	//increment y by 1
				// 	y++;

				// } else if(currentChar.equals(d)) {

				// 	//only valid command left would increment x by 1
				// 	x++;

				// } //else moveOver = true;

			}

				System.out.println(x + " " + y);

				//moveOver = false;

		}
	}
}