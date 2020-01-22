//package Lab5Student;

import java.util.ArrayList;

public class Queue<T> {
	
	private ArrayList<T> elements;
	
	Queue() {
		this.elements = new ArrayList<T>();
	}
	
	//Add an element to the end of the queue
	public void offer(T element) {
		//#TODO
	}
	
	//Retrieve (but do NOT remove) an element from the start of the queue
	//If the queue is empty, return null
	public T peek() {
		//#TODO
	}
	
	//Retrieve AND remove an element from the start of the queue
	//If the queue is empty, return null
	public T poll() {
		//#TODO
	}
	
	
	public static class QueueRunner{
		public static void main(String[] args) {
			Queue queue = new Queue<String>();
			queue.offer("This");
			queue.offer("is");
			queue.offer("a");
			queue.offer("queue");
			
			System.out.println(queue.peek());
			System.out.println(queue.peek());
			System.out.println(queue.peek() + System.lineSeparator());
			
			System.out.println(queue.poll());
			System.out.println(queue.poll());
			System.out.println(queue.poll());
			System.out.println(queue.poll()+ System.lineSeparator());
			
			System.out.println(queue.poll());
			System.out.println(queue.peek());
			
		}
		
	}

}
