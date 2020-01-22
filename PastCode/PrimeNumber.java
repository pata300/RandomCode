/*
	
	Patrick Griffin
	Lab 3
	Problem 1: Prime Number

*/

import java.util.Scanner;

public class PrimeNumber{

	public static void main(String[] args){

		int testCase;
		int num;

		boolean isPrime;

		Scanner input = new Scanner(System.in);

		testCase = input.nextInt();

		for(int i = 0; i < testCase; i++){

			num = input.nextInt();

			isPrime = false;

			if(num == 1){

				isPrime = false;

			} else {

				isPrime = true;

			}

			for(int j = 2; j < num; j++){

				//System.out.println("Num is " + num + " and j is " + j);

				if(num % j == 0){

					isPrime = false;

					j = num;

				} else if(num % j != 0) {

					isPrime = true;
				
				}

			}

			System.out.println(isPrime);

		}
	}
}