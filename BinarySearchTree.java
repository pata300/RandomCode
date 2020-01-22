import java.util.*;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T>{

	/**
	* constructor for BinarySearchTree with no arguments
	*/
	public BinarySearchTree(){
		super();
	}

	/**
	* constructor for BinarySearchTree with array argument
	* @param seq 		takes a generic array to be inserted into the binary search tree
	*/
	public BinarySearchTree(T[] seq){
		super();
		insertWithArray(seq);
	}

	/**
	* constructor for BST with an array and a null symbol
	* @param seq 		takes a generic array to be inserted
	* @param nullSymbol generic value that each value in the array is compared to
	*/
	public BinarySearchTree(T[] seq, T nullSymbol){
		super();
		insertWithArrayAndNullSym(seq, nullSymbol);
	}

	/**
	* returns whether the BST is empty or not
	* @return 			either true/false depending on if the root is null or not
	*/
	public boolean isEmpty(){
		return root == null;
	}

	/**
	* adds each value in an array to the BST in breadth order
	* @param seq 		generic array to be inserted
	*/
	public void insertWithArray(T[] seq){
		for(int i = 0; i < seq.length; i++)
			insert(seq[i]);
	}

	/**
	* compares each value to a given null symbol; if the two values are not equal the value is inserted
	* @param seq 		generic array to be inserted
	* @param nullSymbol generic value to be compared to
	*/
	public void insertWithArrayAndNullSym(T[] seq, T nullSymbol){
		int compareResult; //variable to hold the compared value 
		T value = null; //variable to be inserted
		//loops through the array
		for(int i = 0; i < seq.length; i++){
			value = seq[i]; //grabs the specific value
			compareResult = value.compareTo(nullSymbol); //compares value to the null symbol
			//if the values are not equal
			if(compareResult != 0){
				insert(value); //insert the value into the BST
			}
		}
	}

	/**
	* helper method that calls the recursive version of itself which returns the tree and assigns it back to root
	* @param value 		the value to be inserted into the BST
	*/
	public void insert(T value){
		root = insert(value, root);
	}

	/**
	* recursive method that finds the correct position for the value 
	* by checking whether the value is less than/greater than the existing nodes
	* and inserting in the correct left or right node of the parent
	* @param x 			the value to be inserted/compared to existing values
	* @param t 			the node that will be check next
	* @return 			either the last node that was compared or the root after insertion
	*/
	private BinaryNode<T> insert(T x, BinaryNode<T> t){
		//if this is the root node
		if(t == null){
			return new BinaryNode<T>(x);
		}

		//variable to simplify compare process
		int compareResult = x.compareTo(t.getData());

		//if the value is less than 0
		if(compareResult < 0){
			//check the left node
			t.setLeftNode(insert(x, t.getLeftNode()));
		}
		else if(compareResult > 0){
			t.setRightNode(insert(x, t.getRightNode()));//if greater than we check the right node
		}
		else
			; //if it is equal to 0, then we do nothing
		return t; //return the node
	}

	/**
	* helper method that calls the recursive version of itself, assigns the BST back to root
	* @param value 		the value that is to be removed from the BST
	*/
	public void remove(T value){
		root = remove(value, root);
	}

	/**
	* recursive method that searches the BST for the value and either removes the node if leaf
	* or replaces the value with the minimum of the right subtree and removes the path to that node
	* @param x 			the value to be deleted/compared to existing values
	* @param t 			the node that will be check next
	* @return 			either the last node that was compared or the root after deletion
	*/
	private BinaryNode remove(T x, BinaryNode<T> t){
		if(t == null)
			return t;

		int compareResult = x.compareTo(t.getData());

		//checking left or right nodes
		if(compareResult < 0)
			t.setLeftNode(remove(x, t.getLeftNode()));
		else if(compareResult > 0)
			t.setRightNode(remove(x, t.getRightNode()));
		else if(t.getLeftNode() != null && t.getRightNode() != null){
			//if the value is found AND it has children
			t.setData(findMin(t.getRightNode()).getData()); //set the value of the current node with its minimum child
			t.setRightNode(remove(t.getData(), t.getRightNode())); //reset the right node
		} else{
			//else the nodes are leafs
			if(t.getLeftNode() != null)
				t = t.getLeftNode();
			else
				t = t.getRightNode();
		}

		return t;

	}

	/**
	* helper method for the recursive version of itself
	* @param value 		the value that will be checked for
	* @return 			true if the value is in the BST or false otherwise
	*/
	public boolean contains(T value){
		return contains(value, root);
	}

	/**
	* recursive method that searches through the BST for the value given
	* @param x 			the value to be compared to existing values
	* @param t 			the node that will be check next
	* @return 			either true if the value is found or false if not found
	*/
	private boolean contains(T x, BinaryNode<T> t){
		if(t == null)
			return false;

		int compareResult = x.compareTo(t.getData());

		if(compareResult < 0)
			return contains(x, t.getLeftNode());
		else if(compareResult > 0)
			return contains(x, t.getRightNode());
		else
			return true;
	}

	/**
	* finds the minimum value in a subtree
	* @param node 		the node to be checked
	* @return 			the most left node or null
	*/
	private BinaryNode<T> findMin(BinaryNode<T> node){
		if(node == null)
			return null;
		else if(node.getLeftNode() == null)
			return node;
		return findMin(node.getLeftNode());
	}

} 