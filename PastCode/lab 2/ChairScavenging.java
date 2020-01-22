/*
	
	Patrick Griffin
	Lab 2
	Problem 6: Chair Scavenging

*/

import java.util.Scanner;

public class ChairScavenging{

	public static void main(String[] args){

		int testCase;
		int students;
		int chairs;
		int chairsNeeded;

		Scanner input = new Scanner(System.in);

		testCase = input.nextInt();

		for(int x = 0; x < testCase; x++){

			students = input.nextInt();
			chairs = input.nextInt();

			if(chairs > students){

				chairsNeeded = 0;
				System.out.println(chairsNeeded);

			} else { 

				chairsNeeded = students - chairs;
				System.out.println(chairsNeeded);

			}
		}
	}
}