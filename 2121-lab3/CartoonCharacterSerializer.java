//package Lab3Student;

//#TODO
//Use appropriate imports
//hint: there are a lot!
import java.io.IOException;
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class CartoonCharacterSerializer {
	
	private static ObjectOutputStream outputCartoon;
	private static ObjectInputStream inputCartoon;
	private static PrintWriter writer;

	/*
		The Calendar class essentially gives you everything you need.
		Use the try / catch statements from that class to organize serializeCharacter && deserializeCharacter
		All printToFile is doing is creating a human readable file of what is in the character class
	*/
	
	//Method that writes one CartoonCharacter object out to a file
	public static void serializeCharacter(CartoonCharacter character) {
		//#TODO
		//Initialize outputCartoon to serialize objects to a file called Cartoon.ser
		//Write the character object out to the file
		//Close the stream
		try
		{
			//Writing objects out, one at a time to file eventFile.ser
			outputCartoon = new ObjectOutputStream(new FileOutputStream("Cartoon.ser"));//ObjectOutputStream does the conversion, FileOutputStream pushes the data
			outputCartoon.writeObject(character);//Write party Event object out to eventFile.ser on disk
			outputCartoon.close();//Call .close() to flush any remaining bytes in the stream out to disk and free the memory from the stream
		}
		catch (IOException e)//Must include
		{
			e.printStackTrace();
		}
	}
	
	public static CartoonCharacter deserializeCharacter() {
		CartoonCharacter cartoon = null;
		
		//#TODO
		//Initialize inputCartoon to read objects from a file called Cartoon.ser
		//Read one CartoonCharacter object and store it in variable cartoon
		try
		{
			//Initialize ObjectInputStream to read from file eventFile.ser
			inputCartoon = new ObjectInputStream(new FileInputStream("Cartoon.ser"));//ObjectInputStream does the conversion, FileInputStream pulls the data
			//Read Event objects from file until there are none left to read
			while (true) {
				cartoon = (CartoonCharacter)inputCartoon.readObject();//IMPORTANT, Serialized object must be cast into its correct type when deserializing!
				System.out.println(cartoon);//Print contents of each event
			}
		}
		catch (ClassNotFoundException e)//Must include
		{
			e.printStackTrace();
		}
		catch (IOException e)//Must include
		{
			try {
				inputCartoon.close();
				if (e instanceof EOFException) {//When end of file is reached, print this message
					System.out.println("Reached end of file, " + e);
				} else {
					e.printStackTrace();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		return cartoon;
	}
	
	public static void printToFile(String stringToFile) throws FileNotFoundException {
		//#TODO
		try{
			//Initialize writer to print characters to a file called C-137.txt
			writer = new PrintWriter("C-137.txt");
			//Print stringToFile to that file
			writer.println(stringToFile);
			//Print the string "PrintWriter makes printing 50 times easier!" followed by a newline character out to the file
			writer.println("PrintWriter makes printing 50 times easier!\n");
			//Close the PrintWriter stream
			writer.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}


	}

}
