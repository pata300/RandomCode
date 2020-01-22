/*
	
	Patrick Griffin
	Lab 5
	Problem 1: Geometry

*/

public class Geometry{

	public static double getAreaRectangle(double width, double length){

		double area = length * width;

		return area;
	}

	public static double getAreaCircle(double radius){

		double radiusSqr = Math.pow(radius, 2);
		double area = Math.PI * (radiusSqr);

		return area;

	}

	public static double getAreaTriangle(double base, double height){

		double area = (0.5) * (base * height);

		return area;

	}

	public static double getPerimeterRectangle(double width, double length){

		double perimeter = (2) * (length + width);

		return perimeter;

	}

	public static double getPerimeterCircle(double radius){

		double perimeter = (2 * Math.PI) * (radius);

		return perimeter;

	}

	public static double getPerimeterTriangle(double side1, double side2, double side3){

		double perimeter = side1 + side2 + side3;

		return perimeter;

	}
}