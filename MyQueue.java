import java.util.*;

public class MyQueue<T> {

	private LinkedList<T> linkList; //linked list to be constructed

	/**
	* constructor of the queue, creates a linked list of generic T called linkList
	*/
	public MyQueue(){
		linkList = new LinkedList<T>();
	}

	/**
	* gets the value from the top of the stack and removes the node
	* @return 			the value of the dequeued node
	*/
	public T remove(){
		//get the node from the front of the queue
		T temp = linkList.getFirst();
		linkList.remove();
		return temp;
	}

	/**
	* sets the new node at the end of the queue
	* @param node 		the new node
	*/
	public void add(T node){
		//add the node to the "top" of the stack
		linkList.add(node);
	}

	/**
	* tells if the stack is empty
	* @return 			either true or false if the stack is empty or not
	*/
	public boolean isEmpty(){
		//ask the linked list if it is empty or not
		return linkList.isEmpty();
	}

	/**
	* gives the size of the queue
	* @return 			size of the linked list
	*/
	public int size(){
		return linkList.size();
	}
}