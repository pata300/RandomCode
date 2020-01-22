
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
//import static org.junit.Assert.*;//Comment this out and uncomment
//import junit.framework.* and extends TestCase and things will also work

import junit.framework.*;//Makes TestCase and Asserts work
import java.io.*; //IO Library for testing System.out messages

public class TestRegularShape extends TestCase
{
	private RegularShape triangle;
	private RegularShape square;
	private RegularShapeMonitor shapeMonitor;

	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	private final PrintStream systemOut = System.out;
	
	@Before
	public void setUp()
	{
		triangle =  new Triangle(5);
		square = new Square(5);
		shapeMonitor = new RegularShapeMonitor();

		//Output Streams for testing
		System.setOut(new PrintStream(output));
	}
	
	@Test
	public void testAngles()
	{
		double delta = 0.00001;
		assertEquals(triangle.getAngles(), 60.0, delta);
		assertEquals(square.getAngles(), 90.0, delta);
	}
	
	@Test
	public void testAreas()
	{
		double delta = 0.00001;
		assertEquals(triangle.getArea(), 10.825317547305483, delta);
		assertEquals(square.getArea(), 25.0, delta);
	}

	/*@Test
	public void testSetEdgeLength()
	{
		
	}*/
	
	@Test
	public void testAddObserverAndSetEdgeLengthToZero()
	{
		triangle.addObserver(shapeMonitor);

		output.reset();
		triangle.setEdgeLength(0);
		assertEquals(output.toString(), "Warning! Your shape has edges of length 0!\nNew Area: 0.0\n");
	}

	@Test
	public void testAddObserverAndSetEdgeLengthToNonzero()
	{
		square.addObserver(shapeMonitor);

		output.reset();
		square.setEdgeLength(10);
		assertEquals(output.toString(), "Length of edges has changed. Recalculating Area.\nNew Area: 100.0\n");
	}

	@After
	public void restoreStreams() {
    	System.setOut(systemOut);
	}
	
}