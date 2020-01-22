import java.util.*;

public class MyStack<T> {

	private SinglyLinkedList<T> sLinkList;
	private SinglyLinkedList<T>.Node<T> top;

	public MyStack(){
		sLinkList = new SinglyLinkedList<T>();
		top = sLinkList.getTail();
	}

	/**
	* gets the value from the top of the stack and removes the node
	* @return 				the value of the popped node
	*/
	public T pop(){
		//get the element from the popped node
		T element = top.getValue();
		//remove the node from the linked list/stack
		sLinkList.removeTail();
		top = sLinkList.getTail();
		return element;
	}

	/**
	* gets the value of the tail node
	* @return 				the value of the tail node
	*/
	public T peek(){
		//shows the value of the element in stack
		return top.getValue();
	}

	/**
	* puts the new node at the "top of the stack"
	* @param value 				value of the new node
	*/
	public void push(T value){
		//add the node to the "top" of the stack
		sLinkList.add(value);
		top = sLinkList.getTail();
	}

	/**
	* tells if the stack is empty
	* @return 					either true or false if the stack is empty or not
	*/
	public boolean isEmpty(){
		//ask the linked list if it is empty or not
		return sLinkList.isEmpty();
	}
}