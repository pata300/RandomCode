import java.util.*;

public class testIterator{
	
	public static void main(String[] args){

		LinkedList<String> colors = new LinkedList<String>();

		colors.add("red");
		colors.add("green");
		colors.add("blue");
		colors.add("white");
		colors.add("yellow");

		Iterator<String> itr = colors.iterator();

		for( String item : colors){
			// if(colors.equals("green")){
			// 	colors.remove();
			// 	//item = colors.next();
			// }


			System.out.println(item);
			colors.remove(3);
		}

		// while(itr.hasNext()){
		// 	String newItem = itr.next();
		// 	if(newItem.equals("green")){
		// 		itr.remove();
		// 		newItem = itr.next();
		// 	}
			
		// 	System.out.println(newItem);
		// }
	}
}