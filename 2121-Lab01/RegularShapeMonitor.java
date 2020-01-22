import java.util.Observable;
import java.util.Observer;

public class RegularShapeMonitor implements Observer{

	@Override
	public void update(Observable arg0, Object arg1) {
		//#TODO
		//hint, you don't need to do anything with arg1
		RegurlarShape shape;
		shape = (RegularShape) arg0;
		if(shape.getEdge() == 0){
			System.out.println("Warning! Your shpae has edges of length 0!");
		} else { System.out.println("Length of edges has changed. Recalculating Area."); }
		
	}

}
