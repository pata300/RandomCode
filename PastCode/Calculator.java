import java.util.Scanner;

public class Calculator{
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        boolean isDone = false; 
        while( isDone == false)
        {
            System.out.println("Enter fractional expression, [?] Help, [q] Quit");
            String expression = input.nextLine();
            expression = expression.replaceAll("\\s",""); //Strip all spaces from String
       
            if (expression.equals("?"))
            {
                System.out.println("fractional expression should be formatted as: (a/b)+(c/d), (a/b)-(c/d), (a/b)*(c/d), (a/b)/(c/d)");
            }
            else if (expression.equals("q"))
            {
                isDone = true;
                System.out.println("Thanks for using the Fractional Calculator.");
            }
            else 
            {
                try
                {
                    Scanner parser = new Scanner(expression);
                    parser.useDelimiter("");
                    parser.next();
                    int n1 = getNumber(parser);
                    parser.next();
                    int d1 = getNumber(parser);
                    parser.next();
                    String operator = parser.next();
                    parser.next();
                    int n2 = getNumber(parser);
                    parser.next();
                    int d2 = getNumber(parser);
                    parser.next();
                    calculate(n1, d1, n2, d2, operator);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid input. Use [?] for help.");
                }
            }
        }

    }

    public static void calculate(int n1, int d1, int n2, int d2, String operation)
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

    public static int getNumber(Scanner parser)
    {
        String number = "";
        while( parser.hasNextInt() == true)
        {
            number += parser.next();
        }
        return Integer.valueOf(number);

    }
    
    
}