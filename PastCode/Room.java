
public class Room{

	private String description;

	private Room north;
	private Room east;
	private Room west;
	private Room south;

	public Room(String description){

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

	public void setNorth(Room north){

		this.north = north;
	}

	public void setEast(Room east){

		this.east = east;
	}

	public void setWest(Room west){

		this.west = west;
	}

	public void setSouth(Room south){

		this.south = south;
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

	public String getDescription(){

		return this.description;
	}

	public String getExits(){

		String exitInfo = null;
		Room compareRoom;

		compareRoom = getNorth();
		if(compareRoom != null){

			if(exitInfo == null){
				exitInfo = "[N]orth: " + compareRoom.getDescription() + "\n";
			}else
				exitInfo += "[N]orth: " + compareRoom.getDescription() + "\n";
		}

		compareRoom = this.getEast();
		if(compareRoom != null){

			if(exitInfo == null){
				exitInfo = "[E]ast: " + compareRoom.getDescription() + "\n";
			}else
				exitInfo += "[E]ast: " + compareRoom.getDescription() + "\n";
		}

		compareRoom = this.getWest();
		if(compareRoom != null){

			if(exitInfo == null){
				exitInfo = "[W]est: " + compareRoom.getDescription() + "\n";
			}else
				exitInfo += "[W]est: " + compareRoom.getDescription() + "\n";
		}

		compareRoom = this.getSouth();
		if(compareRoom != null){

			if(exitInfo == null){
				exitInfo = "[S]outh: " + compareRoom.getDescription() + "\n";
			}else
				exitInfo += "[S]outh: " + compareRoom.getDescription() + "\n";
		}

		return exitInfo;

	}

	public String toString(){

		//String roomInfo;

		return this.description + "\n" + this.getExits() ;

	}


}