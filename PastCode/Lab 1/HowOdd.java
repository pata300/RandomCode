/*
	
	Patrick Griffin
	Problem 7: How odd!

*/

import java.util.Scanner;

public class HowOdd {

	public static void main(String[] args) {

		int inputNum;
		boolean isOdd = false;

		Scanner input = new Scanner(System.in);

		//ask user for input
		inputNum = input.nextInt();


		if(inputNum % 2 == 1)
			isOdd = true;

		System.out.println(isOdd);

	}
}