/*
	
	Patrick Griffin
	Lab 2
	Problem 1: Summing It Up

*/

import java.util.Scanner;

public class SummingItUp {

	public static void main(String[] args) {

		int testCase;
		int num1;
		int num2;
		int result;

		//variables to hold a higher and lower number to use in for loop
		int higherNum;
		int lowerNum;

		Scanner input = new Scanner(System.in);

		//ask user for how many cases to test
		testCase = input.nextInt();

		for(int x = 0; x < testCase; x++){

			//get the two integers used to find the sum
			num1 = input.nextInt();
			num2 = input.nextInt();

			result = 0;

			if(num1 > num2){

				higherNum = num1;
				lowerNum = num2;

			} else {

				higherNum = num2;
				lowerNum = num1;

			}

			for(int y = lowerNum; y <= higherNum; y++){

				result += lowerNum;
				lowerNum++;

			}

			System.out.println(result);

		}
	}
}