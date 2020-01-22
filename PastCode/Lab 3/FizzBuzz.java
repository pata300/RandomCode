/*
	
	Patrick Griffin
	Lab 3
	Problem 6: FizzBuzz

*/

import java.util.Scanner;

public class FizzBuzz{

	public static void main(String[] args){

		String fizz = "fizz";
		String buzz = "buzz";

		int testCase;

		int x;

		Scanner input = new Scanner(System.in);

		testCase = input.nextInt();
		//ask user for test conditions

		for(int i = 0; i < testCase; i++){

			x = input.nextInt();
			//gets an integer from the user

			//test if it is a multiple of 3 or 5
			if(x % 3 == 0 && x % 5 == 0){

				System.out.println(fizz + buzz);

			} else if(x % 3 == 0){

				System.out.println(fizz);

			} else if(x % 5 == 0){

				System.out.println(buzz);

			} else {

				System.out.println(x);

			}
		}
	}
}