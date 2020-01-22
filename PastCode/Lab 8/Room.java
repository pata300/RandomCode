/*
	
	Patrick Griffin
	Lab 8
	Problem 2: Dungeon Crawl

*/

public class Room{

	private String name;
	private String description;

	private Room north;
	private Room east;
	private Room west;
	private Room south;

	public Room(String name, String description){

		this.name = name;
		this.description = description;

		this.north = north;
		this.east = east;
		this.west = west;
		this.south = south;

	}

	public void setExits(Room n, Room e, Room w, Room s){

		north = n;
		east = e;
		west = w;
		south = s;

	}

	public Room getNorth(){
		if(this.north == null){
			return null;
		} else
		return this.north;
	}

	public Room getEast(){
		if(this.east == null){
			return null;
		} else
		return this.east;
	}

	public Room getWest(){
		if(this.west == null){
			return null;
		} else
		return this.west;
	}

	public Room getSouth(){
		if(this.south == null){
			return null;
		} else
		return this.south;
	}

	public String getName(){

		return this.name;

	}


	public String getExits(){

		String exitInfo = null;
		Room compareRoom;

		compareRoom = getNorth();
		if(compareRoom != null){

			if(exitInfo == null){
				exitInfo = "[N]orth: " + north.getName() + "\n";
			}else
				exitInfo += "[N]orth: " + north.getName() + "\n";
		}

		compareRoom = this.getEast();
		if(compareRoom != null){

			if(exitInfo == null){
				exitInfo = "[E]ast: " + east.getName() + "\n";
			}else
				exitInfo += "[E]ast: " + east.getName() + "\n";
		}

		compareRoom = this.getWest();
		if(compareRoom != null){

			if(exitInfo == null){
				exitInfo = "[W]est: " + west.getName() + "\n";
			}else
				exitInfo += "[W]est: " + west.getName() + "\n";
		}

		compareRoom = this.getSouth();
		if(compareRoom != null){

			if(exitInfo == null){
				exitInfo = "[S]outh: " + south.getName() + "\n";
			}else
				exitInfo += "[S]outh: " + south.getName() + "\n";
		}

		return exitInfo;

	}

	public String toString(){

		//String roomInfo;

		return "[" + this.name + "]\n" + this.description + "\n" + this.getExits() ;

	}


}