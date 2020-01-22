/*
	
	Patrick Griffin
	Lab 2
	Problem 7: Rock Paper Scissors

*/

import java.util.Scanner;

public class RockPaperScissors{

	public static void main(String[] args){

		String paper = "paper";
		String rock = "rock";
		String scissors = "scissors";

		String player1;
		String player2;

		int testCase;

		Scanner input = new Scanner(System.in);

		testCase = input.nextInt();

		for(int x = 0; x < testCase; x++){

			player1 = input.next();
			player2 = input.next();

			if(player1.equals(rock)){

				if(player2.equals(paper)){

					System.out.println("Player 2 wins!");

				} else if(player2.equals(scissors)){

					System.out.println("Player 1 wins!");

				} else {

					System.out.println("Tie!");

				}

			}

			
			if(player1.equals(paper)){

				if(player2.equals(scissors)){

					System.out.println("Player 2 wins!");

				} else if(player2.equals(rock)){

					System.out.println("Player 1 wins!");

				} else {

					System.out.println("Tie!");
					
				}

			}

			if(player1.equals(scissors)){

				if(player2.equals(rock)){

					System.out.println("Player 2 wins!");

				} else if(player2.equals(paper)){

					System.out.println("Player 1 wins!");

				} else {

					System.out.println("Tie!");
					
				}

			}

		}

	}

}