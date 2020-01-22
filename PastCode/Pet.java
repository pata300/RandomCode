/*
	
	Creator:	Patrick G.
	Date:		10/22/2018
	Assignment:	HW4

	Note:		Must be compiled and ran with VirtualPet.java

*/

import java.util.Scanner;
import java.security.SecureRandom;

public class Pet{

	//the primary pet stats
	private String name;
	private int age;
	private int currentHunger;
	private int currentBoredom;
	private int currentDirtiness;

	//corresponding rates they will increase/decrease
	private int hungerRate;
	private int boredomRate;
	private int dirtinessRate;

	//constants for threshold comparisons
	private final int LOW_STAT_THRESHOLD = 3;
	private final int MED_STAT_THRESHOLD = 6;
	private final int HIGH_STAT_THRESHOLD = 9;
	private final int RUNAWAY_STAT_THRESHOLD = 10;

	//bonus stats
	private String[] petNames = new String[100]; //hold pet names
	private int[] petAges = new int[100];
	private int petIndex = 0;

	public Pet(){

		this.name = name;
		this.age = age;

		this.currentHunger = currentHunger;
		this.currentBoredom = currentBoredom;
		this.currentDirtiness = currentDirtiness;

		this.hungerRate = hungerRate;
		this.boredomRate = boredomRate;
		this.dirtinessRate = dirtinessRate;

	}

	public void createPet(){

		Scanner input = new Scanner(System.in);
		SecureRandom randomNumbers = new SecureRandom();

		//set pet's age to zero
		age = 0;

		System.out.println("A mysterious egg hatches before you!");
		System.out.println("What will you name this creature? ");

		//ask and receive pet's name from user
		name = input.nextLine();

		//sets all current stats and their rates to random numbers
		//stats are set randomly between 0 and 3
		currentHunger = randomNumbers.nextInt(3);
		currentBoredom = randomNumbers.nextInt(3);
		currentDirtiness = randomNumbers.nextInt(3);

		//rates are set randomly between 0 and 2
		hungerRate = randomNumbers.nextInt(2);
		boredomRate = randomNumbers.nextInt(2);
		dirtinessRate = randomNumbers.nextInt(2);

	}

	public void increaseAge(){

		age++;

		String update = "*UPDATE* ";

		System.out.println("\n" + name + " is now " + age + " days old!");

		if(age % 2 == 0){

			hungerRate++;
			System.out.println(update + name + " now gets hungrier faster!");

		}

		if(age % 3 == 0){

			dirtinessRate++;
			System.out.println(update + name + " now gets dirtier quicker!");

		}

		if(age % 5 == 0){

			boredomRate++;
			System.out.println(update + name + " now gets bored faster or whatever...");

		}

	}

	public void getInteraction(){

		Scanner input = new Scanner(System.in);

		System.out.println("1) Feed\n2) Clean\n3) Play");
		System.out.println("What would you like to do with " + name + "?");
		System.out.println("(Input only 1 - 3)");

		int choice = input.nextInt();

		if(choice == 1){

			feedPet();

		}

		if(choice == 2){

			cleanPet();

		}

		if(choice == 3){

			playWithPet();

		}

	}

	public void feedPet(){

		currentHunger -= hungerRate;

		currentDirtiness += dirtinessRate;

		System.out.println(name + " is less hungry, but more dirty!");

	}

	public void cleanPet(){

		currentDirtiness -= dirtinessRate;

		currentBoredom += boredomRate;

		System.out.println(name + " is less dirty, but more bored!");

	}

	public void playWithPet(){

		currentBoredom -= boredomRate;

		currentHunger += hungerRate;

		System.out.println(name + " is less bored, but more hungry!");

	}

	public void displayStats(){

		String status;

		String border = "\n**********************************";
		String statHeader = "\t\tSTATS";

		String hungerDescription = "Hunger Level: ";
		String dirtDescription = "Cleanliness Level: ";
		String boredDescription = "Boredom Level: ";

		System.out.println(border + border);
		System.out.println(statHeader);

		status = getPetStatus(currentHunger);

		System.out.println(hungerDescription + status);

		status = getPetStatus(currentDirtiness);

		System.out.println(dirtDescription + status);

		status = getPetStatus(currentBoredom);

		System.out.println(boredDescription + status);

		System.out.println(border + border);

	}

	public String getPetStatus(int stat){

		String message;

		if(stat < LOW_STAT_THRESHOLD){

			message = "Fantastic!";

		} else if(stat < MED_STAT_THRESHOLD){

			message = "Not terrible, not great...";

		} else if(stat < HIGH_STAT_THRESHOLD){

			message = "Uh oh...";

		} else {

			message = "You messed up, man.";

		}

		return message;

	}

	public Boolean hasPetRunAway(){

		if(currentHunger > RUNAWAY_STAT_THRESHOLD){

			System.out.println("Probably should have fed the little thing. " + name + " has ran away!");
			return true;

		}

		if(currentDirtiness > RUNAWAY_STAT_THRESHOLD){

			System.out.println("Someone didn't like being so dirty. " + name + ", and all its filth, has ran away...");
			return true;

		}

		if(currentBoredom > RUNAWAY_STAT_THRESHOLD){

			System.out.println("You are one boring individual. " + name + " has ran away out of boredom.");
			return true;

		}

		return false;

	}

	public void displayResults(){

		System.out.println("You cared for " + name + " an incredible " + age + " days!");

		if(age < 5){

			System.out.println("Better luck next time..." + name + " is better off.");

		}

		if(age >= 5 && age <= 15){

			System.out.println("Not too bad. Seemed like you and " + name + " had a real connection going.");

		}

		if(age >= 16 && age <= 25){

			System.out.println("Wow! You really knew how to take care of " + name + ". Great job.");

		}

		if(age > 25){

			System.out.println("Were you cheating... or do you you own an actual pet? Either way, you nail'd it.");

		}


	}

	public boolean playAgain(){

		Scanner input = new Scanner(System.in);

		int choice;

		System.out.println("Would you like to play again?");
		System.out.println("1) yes\n2) no");

		choice = input.nextInt();

		if(choice == 1){

			return true;

		} else return false;

	}

	public void savePetData(){

		petNames[petIndex] = name;

		petAges[petIndex] = age;

		petIndex++;

	}

	public void displayPets(){

		System.out.println("*****PET SCORES*****");

		for(int i = 0; i < petIndex; i++){

			System.out.println(petNames[i] + "\t" + petAges[i] + " days");

		}
	}


}





