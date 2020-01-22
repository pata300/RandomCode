/*

	Patrick Griffin
	Lab 6
	Problem 2: Radix Util

*/

public class LogicalUtil{
	
	static boolean thereExists(boolean p, boolean q, boolean r){

		if(p == true || q == true || r == true){

			return true;

		} else return false;

	}

	static boolean forAll(boolean p, boolean q, boolean r){

		if(p == true && q == true && r == true){

			return true;

		} else return false;

	}

	static boolean majority(boolean p, boolean q, boolean r){

		if(p == true && q == true){

			return true;
		
		} else if(p == true && r == true){

			return true;

		} else if(q == true && r == true){

			return true;

		} else return false;

	}

	static boolean implies(boolean p, boolean q){

		if(p == true && q == false){

			return false;
		
		} else return true;

	}

	static boolean implies(boolean p, boolean q, boolean r){

		if(p == true && q == true && r == false){

			return false;

		} else return true;
		
	}
}