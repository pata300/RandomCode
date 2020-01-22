/*
	
	Patrick Griffin
	Problem 6: ASCII endcodings

*/

import java.util.Scanner;

public class ASCIIEncodings {

	public static void main(String[] args) {

		char letter1;
		char letter2;
		char letter3;
		char letter4;
		char letter5;
		char letter6;

		int value1;
		int value2;
		int value3;
		int value4;
		int value5;
		int value6;

		Scanner input = new Scanner(System.in);

		value1 = input.nextInt();
		value2 = input.nextInt();
		value3 = input.nextInt();
		value4 = input.nextInt();
		value5 = input.nextInt();
		value6 = input.nextInt();

		letter1 = (char) value1;
		letter2 = (char) value2;
		letter3 = (char) value3;
		letter4 = (char) value4;
		letter5 = (char) value5;
		letter6 = (char) value6;

		System.out.print(letter1);
		System.out.print(letter2);
		System.out.print(letter3);
		System.out.print(letter4);
		System.out.print(letter5);
		System.out.print(letter6);
		System.out.println();
	}
}