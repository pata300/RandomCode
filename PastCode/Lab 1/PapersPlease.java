/*
	
	Patrick Griffin
	Problem 3: Papers Please

*/

import java.util.Scanner;

public class PapersPlease {

	public static void main(String[] args){

		//booleans that will tell if user has identification or not
		Boolean hasPassport = false;
		Boolean hasLicense = false;
		Boolean hasBirthCert = false;
		Boolean canBoard = false;

		Scanner input = new Scanner(System.in); //to get user input

		//informs user on program
		// System.out.println("You are about to board an airplane.");
		// System.out.println("You are required to have sufficient identification present to board.");
		// System.out.println("*Please type true or false*");

		//grabs a boolean from the user to compare if true or false
		Boolean userInput;

		//ask user for their passport
		// System.out.println("Do you have a passport? (true or false)");

		//takes input of 'true' or 'false'
		userInput = input.nextBoolean();

		//if the user inputs true the boolean is changed to true
		if(userInput)
			hasPassport = true;

		//now the program ask the user for their driver license
		// System.out.println("Do you have your driver's license? (true or false)");

		userInput = input.nextBoolean();

		if(userInput)
			hasLicense = true;

		//same steps for the birth certificate
		// System.out.println("Do you have your birth certificate? (true or false)");

		userInput = input.nextBoolean();

		if(userInput)
			hasBirthCert = true;

		//if the passenger has their passport
		if(hasPassport){

			//they can board
			canBoard = true;

		} else if(hasLicense && hasBirthCert){

			canBoard = true;

		}

		// System.out.println("Boarding Status: " + canBoard);
		System.out.println(canBoard + "\n");

	}
}