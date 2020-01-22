public class FractionTester
{
    
    public static void main(String[] args){
        
        test(1,4,3,2,"+");
        test(1,2,3,2,"+");
        test(9,6,3,12,"+");
        test(1,2,1,3,"+");
        test(-1,2,-1,3,"+");
        test(1,-2,1,-3,"+");
        test(-1,-2,-1,-3,"+");
        test(-1,-2,1,-3,"+");
        test(2,3,1,3,"-");
        test(9,6,3,12,"-");
        test(1,2,2,4,"-");
        test(1,2,5,6,"-");
        test(-1,2,-5,6,"-");
        test(1,2,2,1,"*");
        test(1,4,2,1,"*");
        test(3,4,9,12,"*");
        test(2,1,2,1,"/");
        test(1,3,1,2,"/");

        
    }

    public static void test(int n1, int d1, int n2, int d2, String operation)
    {
    	Fraction fraction1 = new Fraction(n1,d1);
        Fraction fraction2 = new Fraction(n2,d2);
        Fraction result = null;
        switch(operation)
        {
        	case "+": result = fraction1.add(fraction2); break;
        	case "-": result = fraction1.subtract(fraction2); break;
        	case "*": result = fraction1.multiply(fraction2); break;
        	case "/": result = fraction1.divide(fraction2); break;
        }
        System.out.printf("%s%s%s=%s\n",fraction1,operation,fraction2,result);
        
        
    }
    
    
}