/*
	
	Patrick Griffin
	Lab 2
	Problem 3: An Interesting Problem

*/

import java.util.Scanner;

public class PointOfSaleSystem{


	public static void main(String[] args) {

		int numOfItemsOrder;
		int orderNum;
		double result = 0;
		double taxCharge;


		final double hamburger = 1.50;
		final double cheeseBurger = 1.75;
		final double fishSandwich = 2.5;
		final double halfPounder = 2.75;
		final double frenchFries = 0.99;
		final double drink = 1.25;
		final double tax = 0.065;

		Scanner input = new Scanner(System.in);

		numOfItemsOrder = input.nextInt();

		for(int x = 0; x < numOfItemsOrder; x++) {

			orderNum = input.nextInt();

			if(orderNum == 1){

				result = result + hamburger;

			} else if(orderNum == 2) {

				result += cheeseBurger;

			} else if(orderNum == 3){

				result += fishSandwich;

			} else if(orderNum == 4) {

				result += halfPounder;

			} else if(orderNum == 5) {

				result += frenchFries;

			} else { result += drink; }
		
		}

		//System.out.println(result);

		taxCharge = result * tax;

		//System.out.println(taxCharge);

		result += taxCharge;

		System.out.printf("Please pay $%.2f%n", result);
		System.out.println("Thank you for eating at McDowell's!");

	}

}