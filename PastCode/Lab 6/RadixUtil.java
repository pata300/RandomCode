/*

	Patrick Griffin
	Lab 6
	Problem 2: Radix Util

*/

public class RadixUtil{

	static int base2(String binary){

		return Integer.parseInt(binary, 2);

	}

	static String base2(int decimal){

		return Integer.toBinaryString(decimal);

	}

	static int base8(String octal){

		return Integer.parseInt(octal, 8);

	}

	static String base8(int decimal){

		return Integer.toOctalString(decimal);

	}

	static int base16(String hexadecimal){

		return Integer.parseInt(hexadecimal);

	}

	static String base16(int decimal){

		return Integer.toHexString(decimal);
		
	}
}