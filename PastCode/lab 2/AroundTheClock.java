/*
	
	Patrick Griffin
	Problem 8: Around the Clock

*/

import java.util.Scanner;

public class AroundTheClock {

	public static void main(String[] args) {

		int departTime;
		int travelTime;
		int cycleTime;
		int arrivalTime;

		Scanner input = new Scanner(System.in);

		//ask user for inputs
		//departure time
		departTime = input.nextInt();

		//travel time
		travelTime = input.nextInt();

		//figure out 12 hour loop
		cycleTime = (departTime + travelTime) / 12;

		//evaluate arrive time by subtracting the 12 hour loop multiplier from arrival time
		arrivalTime = (departTime + travelTime) - 12 * cycleTime;

		if(arrivalTime == 12) {

			arrivalTime = 0;

		} else if (arrivalTime > 12) {

			arrivalTime =- 12;

		}

		System.out.println(arrivalTime);
		
	}
}