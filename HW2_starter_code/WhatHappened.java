/**
    @author Christopher Summa
    @version 1.0

    parse custom tags with the following command:

    javadoc -tag custom.require:cm:"Precondition:" -tag custom.ensure:cm: "Postcondition:" -Xdoclint:none  *.java

    Specify an output directory for the generated files by adding the `-d ./doc` option of the above command.

    Link to the java API by adding the `-link https://docs.oracle.com/javase/8/docs/api/` option as well.
*/
public class WhatHappened {

    private Pokemon attacker;
    private Pokemon victim;
    private String  typeOfAttack;
    private int amountOfDamageDone;
    
    /**
        @param attacker The pokemon that attacked
        @param victim The pokemon that was attacked
        @param typeOfAttack A descriptive String that states the type of attack made
        @param amtOfDamage The amount of damage dealt in the attack
    */
    public WhatHappened(Pokemon attacker, Pokemon victim, String typeOfAttack, int amtOfDamage) {
        this.attacker = attacker;
        this.victim   = victim;
        this.typeOfAttack = typeOfAttack;
        this.amountOfDamageDone = amtOfDamage;
    }

    /**
        @return The descriptive String stating the type of attack that was made
    */
    public String getTypeOfAttack() {
        return this.typeOfAttack;
    }

    /**
        @return a reference to the Pokemon that made the attack
    */
    public Pokemon getAttacker() {
        return this.attacker;
    }

    /**
        @return a reference to the Pokemon that was attacked
    */
    public Pokemon getVictim() {
        return this.victim;
    }

    /**
        @return the amount of damage that was dealt in the attack
    */
    public int getAmtOfDamage() {
        return this.amountOfDamageDone;
    }

    /**
        @return a String stating exactly what happened in this bout of conflict:
        [Attacker] attacked Pokemon [victim] using [type of attack] for [amount] damage.
    */
    public String toString() {
        String returnval = "";
        returnval += "Pokemon " + attacker.getName() + " attacked Pokemon " + victim.getName() + " using " + typeOfAttack + " for " + amountOfDamageDone + " damage.";
        if (victim.isDead())
            returnval += "Pokemon " + victim.getName() + " is dead.";
        return returnval;
    }

} // end class WhatHappened
