import java.util.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import static org.junit.Assert.*;//Comment this out and uncomment
//import junit.framework.* and extends TestCase and things will also work

//import junit.framework.*;//Makes TestCase and Asserts work
import java.io.*; //IO Library for testing System.out messages

public class TestSelectionSort //extends TestCase
{
	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	private final PrintStream systemOut = System.out;
	
	@Before
	public void setUp()
	{
		//Output Streams for testing
		System.setOut(new PrintStream(output));
	}

	@Test
	public void testSelectionSortMain(){
		output.reset();
		SelectionSort.main(null);
		String submission = output.toString().replace("\r", "");
		//System.out.println(submission);
		assertEquals( getExpectedOutput() , submission);
	}

	public String getExpectedOutput(){
		String out = "";
		out += "[1, 2, 7, 2, 9, 18, 29, 30, 6, 3]\n";
		out += "[1, 2, 7, 2, 9, 18, 29, 30, 6, 3]\n";
		out += "[1, 2, 2, 7, 9, 18, 29, 30, 6, 3]\n";
		out += "[1, 2, 2, 3, 9, 18, 29, 30, 6, 7]\n";
		out += "[1, 2, 2, 3, 6, 18, 29, 30, 9, 7]\n";
		out += "[1, 2, 2, 3, 6, 7, 29, 30, 9, 18]\n";
		out += "[1, 2, 2, 3, 6, 7, 9, 30, 29, 18]\n";
		out += "[1, 2, 2, 3, 6, 7, 9, 18, 29, 30]\n";
		out += "[1, 2, 2, 3, 6, 7, 9, 18, 29, 30]\n";
		out += "[1, 2, 2, 3, 6, 7, 9, 18, 29, 30]\n";
		out += "[1, 2, 2, 3, 6, 7, 9, 18, 29, 30]\n";
		return out;
	}

	@After
	public void restoreStreams() {
    	System.setOut(systemOut);
	}

/* 
*/
	
}