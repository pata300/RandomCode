

public class Square extends RegularShape {

	public Square(int edgeLength){
		super(4, edgeLength);
	}

	@Override
	public void calculateArea(){
		super.area = (Math.sqrt(3)/4) * Math.pow(4, 2);
	}
}