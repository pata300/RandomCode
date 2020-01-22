public class PokemonRunnerExample {

/* an example class to show you examples of how to set up Observers and Observables.
   imagine a Pokemon Day Care, where Pokemon Trainers are responsible for the well-being
   of different Pokemon, and need to be notified with the Pokemon in his/her care or being
   attacked by their classmates
*/

    public static void main(String[] args) {

        // build some Pokemon objects
        Pokemon bob = new Pokemon("Bob",100,17);
        Pokemon joe = new Pokemon("Joe",80,12);
        Pokemon haydar = new Pokemon("Haydar",70,22);
        Pokemon stimpy = new Pokemon("Stimpy",95,11);

        // build some PokemonTrainer objects
        PokemonTrainer larry = new PokemonTrainer("Larry");
        PokemonTrainer camille = new PokemonTrainer("Camille");
        PokemonTrainer devin = new PokemonTrainer("Devin");

        // ok, so now that we've got some Pokemon and Trainers, let's register them
        // so we know who is responsible for who (i.e. which trainers are observers of which Pokemon)

        // both larry and camille are responsible for bob's well being
        bob.addObserver(larry);
        bob.addObserver(camille);

        // devin is responsible for haydar and stimpy
        haydar.addObserver(devin);
        stimpy.addObserver(devin);

        // camille is also responsible for stimpy
        stimpy.addObserver(camille);

        // only larry is responsible for joe's well being
        joe.addObserver(larry);

        // let's set the Pokemon loose - let them get into trouble, and see what happens

        stimpy.attack(haydar); // stimpy is the first one to get into trouble
        haydar.attack(stimpy); // haydar, or course, retaliates
        bob.attack(joe);     // now it's bob's turn to get into the fray
        joe.attack(haydar);  // but joe is convinced that haydar did it

    }

}
