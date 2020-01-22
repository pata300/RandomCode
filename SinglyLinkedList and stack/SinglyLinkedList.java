import java.util.*;

public class SinglyLinkedList<T> implements Iterable<T>{
	private T t;
	
	/**
	Instance varaibles to keep track of head, tail, and size of list
	Also a booleans to keep track if the list is empty or not
	*/
	private Node<T> head;
	private Node<T> tail;
	private int size;
	private boolean isEmpty = true;

	/**
	*	Node class to use within the list class
	*/
	class Node<T>{
		private T data;
		private Node<T> next;

		Node(){
			data = null;
			next = null;
		}

		/**
		* this tells the node where to point to next
		* @param nxNode			give the node that will be next
		*/
		public void setNext(Node<T> nxNode){
			this.next = nxNode;
		}

		/**
		* gets the node's next
		* @return 				the node's next
		*/
		public Node<T> getNext(){
			return this.next;
		}

		/**
		* sets the value of the current node
		* @param element 		the element that will be set to the node's data variable
		*/
		public void setValue(T element){
			this.data = element;
		}

		/**
		* simply gets the data variable from the node
		* @return 				the data variable from node
		*/
		public T getValue(){
			return this.data;
		}
	}

	/**
	* add the given element to the end of the list
	* @param elements 			this is the value that is set to the new node
	*/
	public void add(T element){
		Node<T> addNode = new Node<T>();
		addNode.setValue(element);

		if(head == null){
			head = addNode;
			tail = addNode;
			size = 1;
			isEmpty = false;
		} else {
			tail.setNext(addNode);
			tail = addNode;
			size++;
		}
	}

	/**
	* insert a given element at a given index of the list
	* counting starts with zero from the first
	* @param element 			the value that is assigned to the node's data variable
	* @param index 				the point in the list that the new node will be set
	*/
	public void insertAt(T element, int index){
		Node<T> temp = head;
		for(int i = 0; i < index - 1; i++){
			temp = temp.getNext();
		}
		Node<T> addNode = new Node<T>();
		addNode.setValue(element);
		addNode.setNext(temp.getNext());
		temp.setNext(addNode);
		size++;
	}

	/**
	* remove the first occurrence of the given element from the list
	* @param element 			the value that is searched for in the list
	*/
	public void remove(T element){
		SinglyLinkedListIterator iter = this.iterator();
		boolean elementRemoved = false;
		T current; //= head.getValue();
		while(iter.hasNext()){
			current = iter.next();
			System.out.println(current);
			if(current == element){
				iter.remove();
				System.out.println("removing element");
				elementRemoved = true;
			}

		}
		//size--;
		if(!elementRemoved){
			throw new NoSuchElementException();
		}
	}

	/**
	* searches through the list and removes tail from the list
	*/
	public void removeTail(){
		Node<T> temp = head;
		for(int i = 1; i < this.size() - 1; i++){
			temp = temp.getNext();
		}
		temp.setNext(null);
		tail = temp;
		size--;
		if(size == 0){
			head = null;
		}
	}

	/**
	* remove all elements from the list
	*/
	public void clear(){
		head.setNext(null);
		head.setValue(null);
	}

	/**
	* return true if the list is empty, false otherwise
	* @return 				whether or not the list is empty or not
	*/
	public boolean isEmpty(){
		if(head == null)
			isEmpty = true;
		else
			isEmpty = false;

		return isEmpty;
	}

	/**
	* return the number of elements currently in the list
	* @return 				the number of nodes in the list
	*/
	public int size(){
		return size;
	}

	/**
	* returns the node that is currently the tail of the list
	* @return 				the tail node of the list
	*/
	public Node<T> getTail(){
		return tail;
	}

	/**
	* return the nth value from the first (count starts with zero)
	* @param n 				the spot in the list that we are trying to get the value from
	* @return 				the value of the spot in the list
	*/
	public T getNthFromFirst(int n){
		Node<T> temp = head;
		if(n > size){
			throw new IndexOutOfBoundsException();
		}
		for(int i = 0; i < n; i++){
			temp = temp.getNext();
		}

		return temp.getValue();
	}

	/**
	* return the nth value from the last (count starts with zero)
	* @param n 				the spot in the list that we are trying to get the value from
	* @return 				the value of the spot in the list
	*/
	public T getNthFromLast(int n){
		Node<T> temp = head;
		if(n > size){
			throw new IndexOutOfBoundsException();
		}
		for(int i = 1; i < this.size() - n; i++){
			temp = temp.getNext();
		}

		return temp.getValue();
	}

	/**
	* return an iterator of the list
	* @return 				an iterator of the list
	*/
	public SinglyLinkedListIterator iterator(){
		return new SinglyLinkedListIterator();
	}

	/**
	* return a string representing the content of the list
	* @return 				Either a string representation of the list or an empty message
	*/
	public String toString(){
		Node<T> temp = head;
		String listContent = "";
		
		try{
			for(int i = 0; i < this.size(); i++){
				listContent = listContent + "[" + temp.getValue() + "] ";
				temp = temp.getNext();
			}
			return listContent;
		} catch(NullPointerException e){
			return "list is empty";
		}
	}

	class SinglyLinkedListIterator implements Iterator{
		private Node<T> current;
		private Node<T> temp;
		private int count = 0;

		public SinglyLinkedListIterator(){
			current = head;
		}

		/**
		* gets the "next" value in the iteration
		* @return 				nodeData, the value of the node
		*/
		public T next(){
			//get data from node and move to next node
			T nodeData = null;

			if(count > 0){
				current = current.getNext();
			}
			
			if(current == null){
				throw new NoSuchElementException();
			} else if(current == head){
				nodeData = current.getValue();
				//current = current.getNext();
			} else if(current != head){
				//current = current.getNext();
				nodeData = current.getValue();
			}
			count++;
			return nodeData;
		}

		/**
		* tells the iterator is the list has a next
		* @return 				either true or false
		*/
		public boolean hasNext(){
			if(current.getNext() == null){
				count = 0;
				return false;
			}
			else{
				return true;
			}
		}

		/**
		* removes the current node from the list by looping through the list
		* to the node before and telling that node to set its next to the next next node
		*/
		public void remove(){
			if(current == null){
				throw new UnsupportedOperationException("remove operation is not supported by this iterator");
			} else if(current == head){
				head = current.getNext();
				//current.setNext(null);
				size--;
			} else if(current == tail){
				temp = head;
				for(int i = 0; i < count; i++){
					temp = temp.getNext();
				}
				temp.setNext(null);
				size--;
			} else if(current != head && current != tail) {
				temp = head;
				for(int i = 1; i < count - 1; i++){
					temp = temp.getNext();
				}
				System.out.println("getting next next");
				temp.setNext(current.getNext());
				System.out.println("this is new temp " + temp.getValue());
				size--;
			}
			
		}
	}

}