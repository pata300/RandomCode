/*
	
	Patrick Griffin
	Problem 1: Draughting Dollars

*/

import java.util.Scanner;

public class DraughtingDollars {

	public static void main(String[] args) {

		//declare variables
		double pint = 16;
		double userPercentage = 0; //hold the input for perfect remaining
		double beerPrice = 0;

		//scanner for input
		Scanner input = new Scanner(System.in);

		/*
			a full keg holds 1984 oz
			to figure out the percentage of a keg
			you have to take 1984 * userPercentage

		*/

		//prompts user for percentage input
		// System.out.println("Please enter the percentage of beer remaining in the keg (the range must be between 0.0 to 1.0)");

		//prompts user for price input
		// System.out.println("Followed by the price of the beer per serving (must be $0.00)");

		userPercentage = input.nextDouble();
		//this get the percentage from the user and assigns to userPercentage

		//gets the beer's price for users, assigns to beerPrice
		beerPrice = input.nextDouble();

		//declare variables that hold values for the amount of oz in a keg and a pint
		double kegOunce = 15.5 * 128;

		//evaluate how many ounces are left in the keg
		double remainingKeg = kegOunce * userPercentage; //this evaluates the ounces in a keg
		double remainingPint = remainingKeg / pint; //this evaluates the about of pints you can pour from the keg
		double remainingPrice = beerPrice * remainingPint; //this evaluates the amount of how much all the pints cost

		//prints out the sum of the pints left in the keg
		System.out.printf("There is $%,.2f of beer left in keg%n", remainingPrice);


	}

}