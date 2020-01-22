/*
	
	Patrick Griffin
	Lab 5
	Problem 7: Distance

*/

import java.util.Scanner;

public class Distance{

	public static void main(String[] args){

		double x1;
		double x2;
		double y1;
		double y2;

		double distance;

		int testCase;

		Scanner input = new Scanner(System.in);

		testCase = input.nextInt();

		for(int i = 0; i < testCase; i++){

			x1 = input.nextDouble();
			y1 = input.nextDouble();

			x2 = input.nextDouble();
			y2 = input.nextDouble();

			distance = getDistance(x1, y1, x2, y2);

			System.out.println(distance);

		}
	}

	public static double getDistance(double x1, double y1, double x2, double y2){

		double distance;

		distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

		return distance;

	}
}