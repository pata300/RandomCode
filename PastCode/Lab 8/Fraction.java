/*
	
	Patrick Griffin
	Lab 8
	Problem 1: Fraction

*/

public class Fraction{

	private int numerator;
	private int denominator;

	public Fraction(int numerator, int denominator){

		this.numerator = numerator;
		this.denominator = denominator;

	}

	public Fraction add(Fraction other){

		int addedNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
		int commonDenominator = this.denominator * other.denominator;

		//return simplify(addedNumerator, commonDenominator);
		return simplify(addedNumerator, commonDenominator);

	}

	public Fraction divide(Fraction other){

		int dividedNumerator = this.numerator * other.denominator;
		int dividedDenominator = this.denominator * other.numerator;

		return simplify(dividedNumerator, dividedDenominator);

	}

	public int getDenominator(){

		return this.denominator;

	}

	public int getNumerator(){

		return this.numerator;

	}

	public Fraction multiply(Fraction other){

		int multipliedNumerator = this.numerator * other.numerator;
		int multipliedDenominator = this.denominator * other.denominator;

		return simplify(multipliedNumerator, multipliedDenominator);
	}

	public Fraction simplify(int numerator, int denominator){

		for(int i = denominator; i > 1; i--){

			if((denominator % i == 0) && (numerator % i == 0)){

				numerator = numerator / i;
				denominator = denominator / i;

			}
		}
		
		Fraction simpleFraction = new Fraction(numerator, denominator);

		return simpleFraction;

	}

	public Fraction subtract(Fraction other){

		int subtractedNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
		int commonDenominator = this.denominator * other.denominator;

		//System.out.println("the current value is "+ subtractedNumerator + "and " + commonDenominator);

		return simplify(subtractedNumerator, commonDenominator);
	}

	public String toString(){

		return "(" + numerator + "/" + denominator + ")";

	}

}