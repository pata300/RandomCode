/*
	
	Patrick Griffin
	Lab 8
	Problem 2: Dungeon Crawl

*/

public class DungeonCrawl{

	private String name;
	private String description;

	private Room north;
	private Room east;
	private Room west;
	private Room south;

	public DungeonCrawl(String name, String description){

		this.name = name;
		this.description = description;
		
	}
}