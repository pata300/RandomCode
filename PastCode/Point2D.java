/*
	
	Patrick Griffin
	Lab 8
	Problem 3: Point2D

*/

public class Point2D{

	private double x;
	private double y;

	public Point2D(double x, double y){

		this.x = x;
		this.y = y;

	}

	public double distance(Point2D other){

		return Math.sqrt(Math.pow((other.x - this.x), 2) + Math.pow((other.y - this.y), 2));

	}

	public double getX(){

		return this.x;

	}

	public double getY(){

		return this.y;

	}

	public void moveBy(double dx, double dy){

		this.x += dx;
		this.y += dy;

	}

	public void moveTo(double x, double y){

		this.x = x;
		this.y = y;

	}

	public String toString(){

		String point = String.format("(%.1f,%.1f)", x, y);
		return point;
	}

}