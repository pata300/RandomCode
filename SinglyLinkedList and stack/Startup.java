import java.util.*;

public class Startup{
	
	public static void main(String[] args){
		String infix;
		Scanner input = new Scanner(System.in);
		MyStack<Character> stack = new MyStack<Character>();
		SinglyLinkedList<Character> linkList = new SinglyLinkedList<Character>();

		//gets the user's input
		infix = input.nextLine();
		//builds a infix to post fix object with holds the algorithm
		InfixToPostfix foo = new InfixToPostfix();
		//calls the conversion function to convert the operation to postfix
		foo.conversion(infix);

	}
}