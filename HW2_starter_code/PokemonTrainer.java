import java.util.Observer;
import java.util.Observable;
/**
    @author Christopher Summa
    @version 1.0

    parse custom tags with the following command:

    javadoc -tag custom.require:cm:"Precondition:" -tag custom.ensure:cm:"Postcondition:" -Xdoclint:none  *.java

    Specify an output directory for the generated files by adding the `-d ./doc` option of the above command.

    Link to the java API by adding the `-link https://docs.oracle.com/javase/8/docs/api/` option as well.
*/
public class PokemonTrainer implements Observer {

    private String myName; /** @invariant myName != "" */
    
    /**
        @param name The name of the PokemonTrainer
        @since Sunday, Sep 9, 2018

        @custom.require name != ""
    */
    public PokemonTrainer(String name) {
        myName = name;
    }

    /**
        @return A string corresponding to the PokemonTrainer's name
        @custom.ensure  getName() != ""
    */
    public String getName() {
        return myName;
    
    } 

    @Override
    /**
        {@inheritdoc}
    */
    public void update(Observable obs, Object o) {
        String whatHappened = "";
        whatHappened += this + " is notified that " + o;
        System.out.println(whatHappened);
    }

    /**
        @return Returns a string corresponding the the state of the PokemonTrainer
    */
    public String toString() {
        String returnval = "";
        returnval += "PokemonTrainer " + myName;
        return returnval;
    }

} // end class PokemonTrainer
