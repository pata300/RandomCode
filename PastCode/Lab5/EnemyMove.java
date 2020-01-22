/*
	
	Patrick Griffin
	Lab 5
	Problem 8: Enemy Move

*/

import java.util.Scanner;

public class EnemyMove{

	public static void main(String[] args){

		double x1;
		double x2;
		double y1;
		double y2;

		double speed;

		double distance;
		double dx;
		double dy;

		int testCase;

		Scanner input = new Scanner(System.in);

		testCase = input.nextInt();

		for(int i = 0; i < testCase; i++){

			x1 = input.nextDouble();
			y1 = input.nextDouble();

			speed = input.nextDouble();

			x2 = input.nextDouble();
			y2 = input.nextDouble();

			distance = getDistance(x1, y1, x2, y2);

			dx = getEnemyDistance(x1, x2, speed, distance);
			dy = getEnemyDistance(y1, y2, speed, distance);

			if(dx >= x2 && dy >= y2){

				System.out.printf("x=%.1f", x2);
				System.out.printf(", y=%.1f", y2);
				System.out.print("\n");

			} else {

				System.out.printf("x=%.1f", dx);
				System.out.printf(", y=%.1f", dy);
				System.out.print("\n");

			}

			//System.out.println(distance);

		}
	}

	public static double getDistance(double x1, double y1, double x2, double y2){

		double distance;

		distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

		return distance;

	}

	public static double getEnemyDistance(double coord1, double coord2, double speed, double distance){

		double newCoord;

		newCoord = coord1 + speed / distance * (coord2 - coord1);

		return newCoord;

	}

}
