import java.util.Scanner;
import java.util.Random;

public class DungeonRunner{

	public static void main(String[] args){

	 	Dungeon dungeon = new Dungeon();

	 	Room currentRoom = dungeon.getRoom0();
	 	
	 	char userDirection;

		//quick opener and rules for user
		System.out.println("\n\n**** WELCOME TO THE GAME ****\n");

	 	boolean exploring = true;
	 	boolean fighting = false;

	 	String heroName = getPlayerName();

	 	Hero hero = new Hero(heroName, 100, 25, 10, 3);

	 	while(exploring){

	 		System.out.println();
	 		System.out.println(hero.getName() + " is currently in the " + currentRoom);
	 		System.out.println("******************************************");
	 		System.out.println(hero);

	 		userDirection = getDirection();

	 		Random rando = new Random();

	 		if(userDirection == 'q'){

	 			exploring = false;
	 			System.out.println("Thanks for playing!");

	 		} else if (userDirection == 'n') {

	 			currentRoom = checkDirection(currentRoom, userDirection);

	 		} else if (userDirection == 's') {

	 			currentRoom = checkDirection(currentRoom, userDirection);

	 		} else if (userDirection == 'w') {

	 			currentRoom = checkDirection(currentRoom, userDirection);
	 			
	 		} else if (userDirection == 'e') {

	 			currentRoom = checkDirection(currentRoom, userDirection);
	 			
	 		} else {

	 			System.out.println("Your input was invalid, try again.");

	 		}

	 		if(exploring){

	 			int healChance = rando.nextInt(5);
		 		if(healChance == 3){

		 			hero.getHealed();
		 			System.out.println("You found a potion! Health restored.");

		 		}

	 		}

			int encounterSignal = rando.nextInt(6) + 1;

			if(!exploring){

				encounterSignal = 1;

			}

			if(encounterSignal % 2 == 0){

				char fightChoice;

				System.out.println("!!YOU HAVE ENCOUNTERED A MONSTER!!\n\tFIGHT!!!");
				Monster newMonster = getMonster(encounterSignal);
				System.out.println("A " + newMonster.getName() + " has appeared!");

				fighting = true;
				

				while(fighting){

					int crit = rando.nextInt(10);

					System.out.println("Hero stats:");
					System.out.println(hero);

					System.out.println("Monster stats:");
					System.out.println(newMonster);

					fightChoice = getFightChoice();

					if(fightChoice == 'a' && crit == 5){
						newMonster.takeDamage(hero.getStrength() * 2);
						System.out.println("WHOA! Critical hit.");
						System.out.println("You did " + hero.getStrength() * 2 + " damage.");
					}
					else if(fightChoice == 'a'){
						newMonster.takeDamage(hero.getStrength());
						System.out.println("You did " + hero.getStrength() + " damage.");
					}


					if(fightChoice == 'r'){

						fighting = false;
						System.out.println(hero.getName() + " got away safely.");
					}

					if(fightChoice == 'q'){
						
						fighting = false;
						exploring = false;
						System.out.println("Thanks for playing");

					}

					if(newMonster.getHealth() == 0){

						fighting = false;
						System.out.println("Congrats! Victory!!");
						System.out.println("Hero gained " + newMonster.getXP() + " experience points.");
						
						hero.setXP(newMonster.getXP());
						
						while(hero.getXP() >= hero.getCurrentXP()){
							
							hero.checkIfLvlUp();

						}
					
					}

					if(fighting){

						if(fightChoice == 'b'){

							int blockDamage = newMonster.getStrength() - hero.getDefense();
							System.out.println("Block damage = " + blockDamage);
							hero.takeDamage(blockDamage);

						}else {
							System.out.println("The " + newMonster.getName() + " attacked!");
							hero.takeDamage(newMonster.getStrength());
							System.out.println("The " + newMonster.getName() + " did " + newMonster.getStrength() + " damage.");
						}

					}

					if(hero.getHealth() == 0){

						fighting = false;
						exploring = false;
						System.out.println("Oh, no! You've been defeated!\nGame Over");

					}

				}

			}

	 	}

 	}//end of main()

 	static char getDirection(){

 		Scanner input = new Scanner(System.in);
 		char userDirection = 'q';
	
 		try {

 			System.out.println("\n******************************************");
 			System.out.print("Which direction would you like to travel? ");
 			userDirection = input.nextLine().charAt(0);
 			userDirection = Character.toLowerCase(userDirection);
 			System.out.println();

 			if(userDirection != 'n' || userDirection != 'w'
 				|| userDirection != 'e' || userDirection != 's'
 				|| userDirection != 'q'){

 				new Exception();
 			}

 		} catch (Exception exception) {

 			System.out.println("Not a valid input. Try again.");
 			System.out.println("*****************************\n");

 		}

 		return userDirection;

 	}

 	static char getFightChoice(){

 		Scanner input = new Scanner(System.in);
 		char userDirection = 'q';

 		try {

 			System.out.println("\n******************************************");
 			System.out.println("a: attack\tb: block\tr: run\tq: quit");
 			System.out.print("What would you like to do to the enemy? ");
 			userDirection = input.nextLine().charAt(0);
 			userDirection = Character.toLowerCase(userDirection);
 			System.out.println();

 			if(userDirection != 'a' || userDirection != 'b'
 				|| userDirection != 'r' || userDirection != 'q'){

 				new Exception();
 			}

 		} catch (Exception exception) {

 			System.out.println("Not a valid input. Try again.");
 			System.out.println("*****************************\n");

 		}

 		return userDirection;
 	}

 	static Room checkDirection(Room other, char direction){

 		if(other != null){

 			if(direction == 'n' && other.getNorth() != null)
 				other = other.getNorth();
 			else if(direction == 'e' && other.getEast() != null)
 				other = other.getEast();
 			else if(direction == 'w' && other.getWest() != null)
 				other = other.getWest();
 			else if(direction == 's' && other.getSouth() != null)
 				other = other.getSouth();
 			else
 				System.out.println("Invalid choice");


 		} else { System.out.println("There is no exit in that direction."); }

 		return other;

 	}

 	static String getPlayerName(){

 		String heroName = "Bob";
 		Scanner input = new Scanner(System.in);

 		System.out.println("What would you like to name your hero? ");
 		heroName = input.nextLine();

 		return heroName;

 	}

 	static Monster getMonster(int typeNum){

 		Monster newMonster = new Monster("Default", 1, 1, 1);

 		if(typeNum == 2){

 			newMonster = newMonster.spawn("goblin");

 		}

 		if(typeNum == 4){

 			newMonster = newMonster.spawn("orc");

 		}

 		if(typeNum == 6){

 			newMonster = newMonster.spawn("troll");

 		}

 		return newMonster;
 	
 	}

}