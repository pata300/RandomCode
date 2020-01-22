/*
	
	Patrick Griffin
	Problem 4: Bouncer Bot

*/

import java.util.Scanner;

public class BouncerBot {

	public static void main(String[] args) {

		//variables to hold the dates
		int currentMonth;
		int currentDay;
		int currentYear;
		int birthMonth;
		int birthDay;
		int birthYear;
		int patronAge;

		boolean getIn = false;

		Scanner input = new Scanner(System.in);

		// System.out.println("To get into 'Club B-day' it must be your birthday");
		// System.out.println("and you must be 21 years of age or older");

		// System.out.println("Enter the current date (M## D## Y####)");
		// System.out.println("Followed by your birthday (same format)");
		// System.out.println("on a single line, seperated by single spaces");

		currentMonth = input.nextInt();
		currentDay = input.nextInt();
		currentYear = input.nextInt();

		birthMonth = input.nextInt();
		birthDay = input.nextInt();
		birthYear = input.nextInt();

		patronAge = currentYear - birthYear;
		// System.out.println(patronAge);

		if(currentMonth == birthMonth && currentDay == birthDay && patronAge >= 21)
			getIn = true;

		// if(currentMonth == birthMonth)
		// 	System.out.println("The months match");

		System.out.println(getIn);

		// System.out.println("M" + currentMonth + "D" + currentDay + "Y" + currentYear);
		// System.out.println("BM" + birthMonth + "BD" + birthDay + "BY" + birthYear);


	}

}