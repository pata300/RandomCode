import java.util.Random;

public class Dungeon{

	private Room balcony;
	private Room bedroom1;
	private Room bedroom2;
	private Room dining;
	private Room kitchen;
	private Room northHall;
	private Room southHall;

	public Dungeon(){

		this.balcony = new Room("balcony");
		this.bedroom1 = new Room("bedroom 1");
		this.bedroom2 = new Room("bedroom 2");
		this.dining = new Room("dining");
		this.kitchen = new Room("kitchen");
		this.northHall = new Room("north hall");
		this.southHall = new Room("south hall");

		balcony.setExits(null, null, null, northHall);
		bedroom1.setExits(null, null, northHall, bedroom2);
		bedroom2.setExits(bedroom1, null, southHall, null);
		dining.setExits(kitchen, southHall, null, null);
		kitchen.setExits(null, northHall, null, dining);
		northHall.setExits(balcony, bedroom1, kitchen, southHall);
		southHall.setExits(northHall, bedroom2, dining, null);

	}

	public Room getRoom0(){

		Room firstRoom = new Room("default");

		Random randoRoom = new Random();
		int roomNum = randoRoom.nextInt(7) + 1;
		//randoRoom += 1;

		switch(roomNum){

			case 1:
					firstRoom = balcony;
					break;

			case 2:
					firstRoom = bedroom1;
					break;

			case 3:
					firstRoom = bedroom2;
					break;

			case 4:
					firstRoom = dining;
					break;

			case 5:
					firstRoom = kitchen;
					break;

			case 6:
					firstRoom = northHall;
					break;

			case 7:
					firstRoom = southHall;

			default:
					System.out.println("error!");

		}

		return firstRoom;

	}

}