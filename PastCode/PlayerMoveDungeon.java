/*
	
	Patrick Griffin
	Lab 3
	Problem 5: Player Move Dungeon

*/

import java.util.Scanner;

public class PlayerMoveDungeon{

	public static void main(String[] args){

		int x;
		int y;
		//keep track of playerMove coordinates

		int gridLength;
		int gridWidth;
		//these variables will represent our dungeon grid

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

		testCase = input.nextInt(); //ask player for test cases

		//begin our test cases
		for(int i = 0; i < testCase; i++){

			gridLength = input.nextInt();
			gridWidth = input.nextInt();
			//gets the dungeon's size

			gridLength -= 1;
			gridWidth -= 1;
			//get the true size since the grid starts at 0

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

			for(j = 0; j < playerMove.length(); j++){
			//while(j < stringLength){

				currentChar = playerMove.charAt(j);

				if(currentChar == 'w'){

					if(y > 0){

						y--;
					
					}

				} else if(currentChar == 'a'){

					if(x > 0){

						x--;

					}

				} else if(currentChar == 's'){

					if(y < gridLength){

						y++;
					
					}

				} else if(currentChar == 'd'){

					if(x < gridWidth){

						x++;
					
					}

				}

			}

				System.out.println(x + " " + y);

				//moveOver = false;

		}
	}
}