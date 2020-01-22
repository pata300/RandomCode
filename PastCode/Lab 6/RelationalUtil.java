/*

	Patrick Griffin
	Lab 6
	Problem 4: Relational Util

*/

public class RelationalUtil{

	static boolean isIncreasing(int x, int y, int z){

		if(x < y && y < z){

			return true;

		} else { return false; }

	}

	static boolean isDecreasing(int x, int y, int z){

		if(x > y && y > z){

			return true;

		} else { return false; }

	}

	static boolean isBetween(int x, int y, int z){

		if((x < y && y < z) || (x > y && y > z)){

			return true;

		} else { return false; }

	}

	static boolean isPositive(int x){

		if(x > 0){

			return true;

		} else { return false; }

	}

	static boolean isNegative(int x){

		if(x < 0){

			return true;

		} else { return false; }

	}

	static boolean overlaps(int min1, int max1, int min2, int max2){

		if(min1 >= min2 && min1 < max2){

			return true;

		} else if(min2 >= min1 && min2 < max1){

			return true;

		} else if(max1 >= min2 && max1 < max2){

			return true;

		} else if(max2 >= min1 && max2 < max1){

			return true;

		} else { return false; }

	}


}