

public class Triangle extends RegularShape {

	public Triangle(int edgeLength){
		super(3, edgeLength);
	}

	@Override
	public void calculateArea(){
		super.area = (Math.sqrt(3)/4) * Math.pow(3, 2);
	}
}