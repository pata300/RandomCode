/*
	
	Patrick Griffin
	Lab 7
	Problem 1: Array Util

*/


public class ArrayUtil {

	//Part 1:	Reverse Array
	static void reverse(String[] array){

		for(int i = 0; i < array.length / 2; i++){

			String temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;

		}

	}

	//Part 2: Array Resize
	static String[] resize(String[] array){

		String[] arr = new String[array.length * 2];

		for(int i = 0; i < arr.length - 1; i++){

			arr[i] = array[i];

		}

		return arr;

	}

	//Part 3: Add Item
	static String[] add(String element, String[] array){

		//String[] arr = new String[array.length];

		if(array[array.length - 1]!= null){

			String[] arr = resize(array);

			for(int i = 0; i < arr.length - 1; i++){

				if(arr[i] == null){

					arr[i] = element;
					break;
				}

			}

			return arr;

		}
		else{

			for(int i = 0; i < array.length - 1; i++){

				if(array[i] == null){

					array[i] = element;

					break;

				}

			} 

			return array;
			
		}
		
	}

	//Part 4: Array Contains
	static boolean contains(String element, String[] array){

		for(int i = 0; i < array.length - 1; i++){

			if(array[i].equals(element)){

				return true;

			}

		} 

		return false;

	}
}