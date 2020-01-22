/*
	
	Patrick Griffin
	Lab 2
	Problem 3: An Interesting Problem

*/
import java.util.Scanner;

public class AnInterestingProblem {

	public static void main(String[] args) {

		int cases;
		double interestRate;
		int interestInput;
		int deposit;
		double interestDecimal;

		int year;
		double result;

		boolean aMillion = false;

		Scanner input = new Scanner(System.in);

		cases = input.nextInt();

		for(int x = 0; x < cases; x++){

			deposit = input.nextInt();
			interestInput = input.nextInt();

			interestDecimal = interestInput * 0.01;

			//System.out.println(interestDecimal);

			interestRate = deposit * interestDecimal;

			//System.out.println(interestRate);

			result = deposit + interestRate;
			year = 1;

			//System.out.println(result);

			aMillion = false;

			if(result < 1000000){

				while(!aMillion) {

					interestRate = result * interestDecimal;
					//interestRate = result / interestInput;
					result = result + interestRate;
					//System.out.println(result);
					year++;

					if(result >= 1000000)
						aMillion = true;

				}

			}

			System.out.println(year + " years");

		}

	}
} 