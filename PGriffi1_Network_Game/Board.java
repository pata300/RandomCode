
import java.io.IOException;
import java.lang.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author pata
 * 
 * Board class handles the player's "Board". This could be thought of as the radar in which to hold information about hits and miss
 * against your opponent.
 *
 */
public class Board {
	Scanner input = new Scanner(System.in);
	private String[][] radar = new String[10][10];
	private String[][] refRadar;
	Ship smallShip;
	Ship mediumShip;
	Ship largeShip;
	
	/**
	 * The constructor initializes a 10 x 10 array with the strings a player can type in to "shoot" a torpedo to that coordiante
	 */
	public Board() {
		
		char letter = 'A';
		int letterValue;
		int tempNum;
		String position;
		String number;
		
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				tempNum = j+1;
				number = Integer.toString(tempNum);
				position = Character.toString(letter) + number;
				//position += Character.toString(number);
				radar[i][j] = position;
			}
			letterValue = (int) letter;
			letterValue++;
			letter = (char) letterValue;
		}
		refRadar = backup(radar);
	}
	

	protected void setShips() {
		smallShip = new Ship(2, "Small Ship");
		setOnBoard(smallShip);
		
		mediumShip = new Ship(3, "Medium Ship");
		setOnBoard(mediumShip);
		
		largeShip = new Ship(4, "Large Ship");
		setOnBoard(largeShip);
		
		radar = backup(refRadar);
	}
	
	/**
	 * Ask player for the coordinates where they want their ships.
	 * @param currentShip		the ship that is currently being assigned coordinates
	 */
	private void setOnBoard(Ship currentShip) {
		char letter;
		boolean validInput = false;
		int letterValue;
		int num;
		String coord;
		String orient;
//		String[][] backup = radar.clone();
		String[][] loopBackup = new String[10][10];
		//System.out.println("loop backup: " + loopBackup.toString());
		
		while(!validInput) {
			try {
				System.out.println(this);
				System.out.println("Where would you like the " + currentShip.getShipType() + " of size " + currentShip.getSize() + "?");
				System.out.println("Give a coordinate. Ex: A2, F6, d9, etc...");
				System.out.println(">");
				coord = input.nextLine();
				System.out.println("Would you like to set it vertical (V) or horizontal (H)?");
				System.out.println("(input V or H for the respective orientation, lowercase is fine)");
				System.out.println(">");
				
				while(!validInput) {
					orient = input.nextLine();
					
					letter = coord.toUpperCase().charAt(0);
					letterValue = (int) letter;
					letterValue -= 65;
					num = Integer.parseInt(coord.substring(1));
					num -= 1;
					String tempCoor;
					loopBackup = backup(radar);
					
					if(orient.toUpperCase().equals("H")) {
						for(int i = 0; i <= currentShip.getSize() - 1; i++) {
							if(radar[letterValue][num].equals("X "))
								radar[100][0].toString();
							tempCoor = radar[letterValue][num];
							currentShip.addCoordinate(tempCoor);
							radar[letterValue][num] = "X ";

							num++;
						}
						validInput = true;
						//loopBackup = radar.clone();
					} else if(orient.toUpperCase().equals("V")){
						for(int i = 0; i <= currentShip.getSize() - 1; i++) {
							if(radar[letterValue][num].equals("X "))
								radar[100][0].toString();
							tempCoor = radar[letterValue][num];
							currentShip.addCoordinate(tempCoor);
							radar[letterValue][num] = "X ";

							letterValue++;
						}
						validInput = true;
						//loopBackup = radar.clone();
					}
						
				}
				
			} catch(Exception e) {
				System.out.println("Ship is out of bounds. Try again.");
				currentShip.getCoordinates().clear();
				radar = backup(loopBackup);
			}
		}

		
	}
	
	protected ArrayList<String> getSmallShip(){
		return smallShip.getCoordinates();
	}
	
	protected ArrayList<String> getMediumShip(){
		return mediumShip.getCoordinates();
	}
	
	protected ArrayList<String> getLargeShip(){
		return largeShip.getCoordinates();
	}
	
	/**
	 * Updates player's board in the event of a hit ship with a X
	 * @param input		the coordinate that was hit
	 * @return
	 */
	protected boolean updateBoard(String input) {		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(radar[i][j].equals(input)) {
					radar[i][j] = "X ";
					//TO DO: update ships
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Updates player's board in the event of a miss with a M
	 * @param input		the coordinate where the miss occurred
	 */
	protected void updateMiss(String input) {		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(radar[i][j].equals(input)) {
					radar[i][j] = "M ";
					
				}
			}
		}
		
	}
	
	/**
	 * Check if the input is on the board.
	 * @param input		coordinate that is being checked against the board
	 * @return			true if found, false otherwise
	 */
	protected boolean checkInput(String input) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(refRadar[i][j].equals(input)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Updates ships in the event of a hit with a X
	 * @param input		the coordinate of the hit ship
	 */
	protected void updateShips(String input) {
		//System.out.println("updateShips " + input);
		Ship temp = smallShip;
    	for(int i = 0; i < 3; i++) {
    		
//        	
        	for(int j = 0; j < temp.getCoordinates().size(); j++) {
        		if(temp.getCoordinates().get(j).equals(input))
        			temp.getCoordinates().set(j, "X");
        	}
        	if(i == 0)
        		temp = mediumShip;
        	else if(i == 1)
        		temp = largeShip;
    	}
	}
	
	/**
	 * Creates a copy of the board.
	 * @param temp		the current board being copied
	 * @return			the copy of the new board
	 */
	protected String[][] backup(String[][] temp) {
		String[][] dest = new String[10][10];
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				dest[i][j] = temp[i][j];
			}
		}
		return dest;
	}
	
	@Override
	public String toString() {
		String board = "\n\t  ***Radar***\n";
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				board += "|" + radar[i][j];
			}
			board += "\n-------------------------------\n";
		}
		board += "X = HIT	M = MISS\n";
		if(smallShip != null)
			board += smallShip.toString();
		if(mediumShip != null)
			board += mediumShip.toString();
		if(largeShip != null)
			board += largeShip.toString();
		
		return board;
	}
}
