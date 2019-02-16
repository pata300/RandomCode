public class PokemonRunnerExample {

/* an example class to show you examples of how to set up Observers and Observables.
   imagine a Pokemon Day Care, where Pokemon Trainers are responsible for the well-being
   of different Pokemon, and need to be notified with the Pokemon in his/her care or being
   attacked by their classmates
*/

    public static void main(String[] args) {

        /*
        for tester
        construct two pokemon to fight
        construct a trainer to observe
        have pokemon fight
        have pokemon faint
        test each expected string to what actually in the buffer
        */

        // build some Pokemon objects
        Pokemon bob = new Pokemon("Bob",100,17);
        Pokemon joe = new Pokemon("Joe",80,12);
        Pokemon haydar = new Pokemon("Haydar",70,22);
        Pokemon stimpy = new Pokemon("Stimpy",95,11);

        Pokemon pata = new Pokemon("Pata", 100, 10);
        Pokemon nero = new Pokemon("Nero", 24, 10);

        // build some PokemonTrainer objects
        PokemonTrainer larry = new PokemonTrainer("Larry");
        PokemonTrainer camille = new PokemonTrainer("Camille");
        PokemonTrainer devin = new PokemonTrainer("Devin");

        PokemonTrainer patrick = new PokemonTrainer("Patrick");
        PokemonTrainer mandy = new PokemonTrainer("Mandy");

        // ok, so now that we've got some Pokemon and Trainers, let's register them
        // so we know who is responsible for who (i.e. which trainers are observers of which Pokemon)

        // both larry and camille are responsible for bob's well being
        bob.addObserver(larry);
        bob.addObserver(camille);

        // // devin is responsible for haydar and stimpy
        haydar.addObserver(devin);
        stimpy.addObserver(devin);

        // // camille is also responsible for stimpy
        stimpy.addObserver(camille);

        // // only larry is responsible for joe's well being
        joe.addObserver(larry);

        pata.addObserver(mandy);
        nero.addObserver(patrick);
        pata.addObserver(patrick);

        // let's set the Pokemon loose - let them get into trouble, and see what happens

        /*
        when attack() is called
        attack calls takeDAamage()
        notifies the observer
        starts a string "PokemonTrainer TrainerName is notified that " + WhatHappened obj
        WhatHappened obj adds "Pokemon " + attacker.getName() + " attacked Pokemon " + victim.getName() 
        + " using " + typeOfAttack + " for " + amountOfDamageDone + " damage."
        && if pokemon health == 0
        also prints "Pokemon " + victim.getName() + " is dead."
        */

        stimpy.attack(haydar); // stimpy is the first one to get into trouble
        haydar.attack(stimpy); // haydar, or course, retaliates
        bob.attack(joe);     // now it's bob's turn to get into the fray
        joe.attack(haydar);  // but joe is convinced that haydar did it

        System.out.println();

        nero.attack(pata);
        pata.attack(nero);
        pata.attack(nero);
        pata.attack(nero);
        pata.attack(nero);

        System.out.println();

        System.out.println(pata.countObserversInClass()); //should print 2
        pata.deleteObserver(patrick);
        System.out.println(pata.countObserversInClass()); //should print 1

        pata.addObserver(mandy);
        pata.addObserver(mandy);
        System.out.println(pata.countObserversInClass()); //should print 3
        pata.deleteObservers();
        System.out.println(pata.countObserversInClass()); //should print 0

    }

}
