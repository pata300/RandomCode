public class FractionRunner{

	public static void main(String[] args){

		Fraction f1 = new Fraction(1, 2);
		Fraction f2 = new Fraction(1, 3);

		Fraction f3 = f1.add(f2);

		System.out.println(f1 + " + " + f2 + " = " + f3);

	}
}