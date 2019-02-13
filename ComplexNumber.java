/**
 * @author Patrick J. Griffin
 * @since Jan 30, 2019
 */

public class ComplexNumber{

    private float complexA;
    private float complexB;

   /**
    * 
    * @param complexA first real number of the comlex number
    * @param complexB second real number of the complex number
    */ 
    //constructor with 2 parameters
    public ComplexNumber(float complexA, float complexB){
        this.complexA = complexA;
        this.complexB = complexB;
    }

    //eight methods
    //four will implement complex addition, subtraction, multiplication, and division
    //each will return a complex number 
    
    /**
     * 
     * @param newNumber is a second complex number to be added to the first
     * @return will return the sum of the two complex numbers
     */
    public ComplexNumber add(ComplexNumber newNumber){
        ComplexNumber newComplex;
        float newA = complexA + newNumber.getA();
        float newB = complexB + newNumber.getB();
        newComplex = new ComplexNumber(newA, newB);
        return newComplex;
    }

    /**
     * 
     * @param newNumber
     * @return will return the difference of the two complex numbers
     */
    public ComplexNumber subtract(ComplexNumber newNumber){
        ComplexNumber newComplex;
        float newA = complexA - newNumber.getA();
        float newB = complexB - newNumber.getB();
        newComplex = new ComplexNumber(newA, newB);
        return newComplex;
    }

    /**
     * 
     * @param newNumber
     * @return will returnt the product of the two complex numbers
     */
    public ComplexNumber multiply(ComplexNumber newNumber){
        ComplexNumber newComplex;
        float newA = (complexA * newNumber.getA()) - (complexB * newNumber.getB());
        float newB = (complexB * newNumber.getA()) + (complexA * newNumber.getB());
        newComplex = new ComplexNumber(newA, newB);
        return newComplex;
    }

    /**
     * 
     * @param newNumber
     * @return will return the quotient of the two complex numbers
     */
    public ComplexNumber divide(ComplexNumber newNumber){
        ComplexNumber newComplex;
        float newA = ((complexA * newNumber.getA()) + (complexB * newNumber.getB()));
        newA = (float)(newA / (Math.sqrt(newNumber.getA()) + Math.sqrt(newNumber.getB())));
        float newB = ((complexB * newNumber.getA()) - (complexA * newNumber.getB()));
        newB = (float)(newB / (Math.sqrt(newNumber.getA()) + Math.sqrt(newNumber.getB())));
        newComplex = new ComplexNumber(newA, newB);
        return newComplex;
    }

    //two methods are getters getA(), getB()
    //one for part a of the complex number, one for part b
    //a method overriding the equals method
    //and a toString method
    
    /**
     * 
     * @return the instance variable containing the first real number of the complex number
     */
    public float getA(){
        return complexA;
    }

    /**
     * 
     * @return the instance variable containing the second real number of the complex number
     */
    public float getB(){
        return complexB;
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof ComplexNumber){
            ComplexNumber newNumber = (ComplexNumber)other;
            if (newNumber.getA() == complexA &&
                newNumber.getB() == complexB)
                return true;
        }
        return false;
    }

    /**
     * @return a string representing the complex number
     */
    @Override
    public String toString(){
        return (complexA + " + " + complexB + "i");
    }

}