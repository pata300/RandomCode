import java.util.*;

public class InfixToPostfix{
	/**
	* private instance variables to keep track of the:
	* stack
	* stack "data"
	*/
	private MyStack<Character> stack = new MyStack<Character>();
	private char stackData;
	private boolean parenthesesPush = false;

	/**
	* checks for operation symbols and prints anything else to the screen
	* if a operation symbol is matched then checkInfix() is called
	* @param input 				this is a string from the user
	*/
	public void conversion(String input){
		for(int i = 0; i < input.length(); i++){
			//if( (, ), *, /, +, - )
			char infixChar = input.charAt(i);
			if(	
				infixChar == '('||
				infixChar == ')'||
				infixChar == '*'||
				infixChar == '/'||
				infixChar == '+'||
				infixChar == '-'){
			
				checkInfix(infixChar);
			}
			else
				System.out.print(input.charAt(i));
		}
		//once we have analyzed the input, we pop all
		while(!stack.isEmpty()){
			System.out.print(stack.pop());
		}
	}

	/**
	* the infix to post fix algorithm is implement here
	* @param infix 				the character that is being compared to the stack
	*/
	public void checkInfix(char infix){

		if(infix == '('){
			stack.push(infix);
		} else if(infix == ')'){
			while(!stack.isEmpty() && stack.peek() != '('){
				System.out.print(stack.pop());
			}

			if(!stack.isEmpty() && stack.peek() != '(')
				System.out.println("Invalid Expression");
			else
				stack.pop();

		} else {
			while(!stack.isEmpty() && priority(infix) <= priority(stack.peek())){
				if(stack.peek() == '(')
					System.out.println("Invalid Expresssion");
				System.out.print(stack.pop());
			}
			stack.push(infix);
		}

		
	}

	/**
	* checks for what the priority of the operation symbol is
	* @return 				a number determining its value or a -1 if invalid
	*/
	int priority(char ch){
		switch(ch){
			case '+':
			case '-':
				return 1;

			case '*':
			case '/':
				return 2;

			}
			return -1;
	}

}
