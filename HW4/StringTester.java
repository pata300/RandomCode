import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;

public class StringTester{

    private static StringCompare sCompare = new StringCompare();
    private static ArrayList aList = new ArrayList<String>();
    private static String s1;
    private static String s2;
    private static String s3;

    @BeforeClass
    public static void setup(){
        s1 = "patrick";
        s2 = "Patty";
        s3 = s1;

        aList.add(s1);
        aList.add(s2);
        aList.add(s3);
        aList.add("Mandy");
        aList.add("Paul");
        aList.add("Charles");
        aList.add("Dan");
        aList.add("Bree");
        aList.add("Smeech");
        aList.add("Kelly");
        aList.add("Tank");
        aList.add("Tessa");
        aList.add("Vickie");
    }

    @Test
    public void testCompareTo(){

        int x = sCompare.compareTo(s1, s2);
        assertEquals(-1, x);

        x = sCompare.compareTo(s2, s1);
        assertEquals(1, x);

        x = sCompare.compareTo(s1, s3);
        assertEquals(0, x);

        x = sCompare.compareTo("patric", s1);
        assertEquals(-1, x);

        x = sCompare.compareTo("aString", "aString");
        assertTrue(x == 0);

        x = sCompare.compareTo("following", "aString"); //s1 comes after s2 returns 1
        assertTrue(x > 0);

        x = sCompare.compareTo("before", "laterString"); //s1 comes before s2 returns -1
        assertTrue(x < 0);

    }

    @Test
    public void testMinString(){
        String minString = sCompare.findMinimum(aList);
        assertEquals("Bree", minString);
    }

}