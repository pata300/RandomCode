

import java.util.ArrayList;

public class Ship {
	
	private int size;
	private int healthPoints;
	private String shipType;
	private Boolean sunk = false;
	private ArrayList<String> shipCoordinates;
	
	public Ship(int size, String shipType) {
		this.size = size;
		healthPoints = size;
		this.shipType = shipType;
		shipCoordinates = new ArrayList<String>(size);
	}
	
	protected void takesHit() {
		System.out.println("HIT");
		healthPoints--;
		if(healthPoints == 0) {
			this.sunk = true;
		}
	}
	
	protected void addCoordinate(String coordinate) {
		shipCoordinates.add(coordinate);
	}
	
	protected ArrayList<String> getCoordinates(){
		return this.shipCoordinates;
	}
	
	
	protected void checkForHit(String coordinate) {
		int count = 0;
		Boolean hit = false;
		for(String c : shipCoordinates) {
			if(c.equals(coordinate)) {
				takesHit();
				shipCoordinates.remove(count);
				hit = true;
				break;
			}
			count++;
		}
		if(hit) {
			System.out.println("SPLOOSH");
		}
	}
	
	protected Boolean hasSunk() {
		if(sunk)
			return true;
		else
			return false;
	}
	
	protected int getSize() {
		return this.size;
	}
	
	protected String getShipType() {
		return this.shipType;
	}
	
	@Override
	public String toString() {
//		if(shipType.equals("L"))
//			return "large ship (size of 4)";
//		else if(shipType.equals("M"))
//			return "meduim ship (size of 3)";
//		else
//			return "small ship (size of 2)";
		String shipView = "\n" + getShipType() + ":\n<";
		for(String c : shipCoordinates) {
			shipView += "|" + c + "|";
		}
		return shipView + "]\n";
	}
	
}
