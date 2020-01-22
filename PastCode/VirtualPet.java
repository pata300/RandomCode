public class VirtualPet{
	
	public static void main(String[] args){

		boolean newGame = true;

		Pet myPet = new Pet();

		while(newGame){

			myPet.createPet();

			boolean hasRanAway = false;

			while(!hasRanAway){

				//will increment the pets age and manage difficulty
				myPet.increaseAge();
				//ask user for what kind of interaction they want to have with their pet
				myPet.getInteraction();
				//displays how their pet is doing
				myPet.displayStats();
				//determinds if user's pet has decided to stay or not
				hasRanAway = myPet.hasPetRunAway();

			}

			//gives the user a closing stat of how they did
			myPet.displayResults();

			myPet.savePetData();

			newGame = myPet.playAgain();

		}

		myPet.displayPets();

	}
}