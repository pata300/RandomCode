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

public class TestBinarySearch //extends TestCase
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
	public void testBinarySearchMain(){
		output.reset();
		BinarySearch.main(null);
		String submission = output.toString().replace("\r", "");
		assertEquals( getExpectedOutput() , submission);
	}

	public String getExpectedOutput(){
		String out = "";
		out += "high index: 9	low index: 0	middle index: 4\n";
		out += "value at middle index: 9\n";
		out += "high index: 3	low index: 0	middle index: 1\n";
		out += "value at middle index: 2\n";
		out += "high index: 3	low index: 2	middle index: 2\n";
		out += "value at middle index: 7\n";
		out += "high index: 3	low index: 3	middle index: 3\n";
		out += "value at middle index: 8\n";
		out += "3\n";
		return out;
	}

/*
high index: 9	low index: 0	middle index: 4
value at middle index: 9
high index: 3	low index: 0	middle index: 1
value at middle index: 2
high index: 3	low index: 2	middle index: 2
value at middle index: 7
high index: 3	low index: 3	middle index: 3
value at middle index: 8
3
*/

	@After
	public void restoreStreams() {
    	System.setOut(systemOut);
	}

/* 
*/
	
}