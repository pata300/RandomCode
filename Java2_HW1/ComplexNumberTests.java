import static org.junit.Assert.*;
import org.junit.*;

//import jdk.internal.jline.internal.TestAccessible;

public class ComplexNumberTests{

    private ComplexNumber c1;
    private ComplexNumber c2;
    private ComplexNumber c3;
    private ComplexNumber c4;

    private ComplexNumber sum;
    private ComplexNumber diff;
    private ComplexNumber prod;
    private ComplexNumber quot;

    @Before
    public void setup(){
        c1 = new ComplexNumber(1, 1);
        c2 = new ComplexNumber(10, 10);
        c3 = new ComplexNumber(2, 1);

        sum = new ComplexNumber(12, 11);
        diff = new ComplexNumber(8, 9);
        prod = new ComplexNumber(10, 30);
        quot = new ComplexNumber(6, 2);

        System.out.println("setup module ran");
    }

    @Test
    public void testComplexState(){
        assertEquals(1, c1.getA(), 1);
        assertEquals(1, c1.getB(), 1);
    }

    // @Test
    // public void testComplexMathMethods(){
    //     //find if the sum is correct
    //     // c4 = c2.add(c3);
    //     // assertFalse(c4.equals(sum));

    //     // //find if the difference is correct
    //     // c4 = c2.subtract(c3);
    //     // assertTrue(c4.equals(diff));

    //     // //find if the product is correct
    //     // c4 = c2.multiply(c3);
    //     // assertTrue(c4.equals(prod));

    //     // //find if the quotient is correct
    //     // c4 = c2.divide(c3);
    //     // assertTrue(c4.equals(quot));
    // }
}