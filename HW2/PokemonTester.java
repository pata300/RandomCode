import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;
import org.junit.*;

//import jdk.internal.jline.internal.TestAccessible;

public class PokemonTester {

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private ByteArrayOutputStream errorOutput = new ByteArrayOutputStream();

    private String lineSeparator = System.getProperty("line.separator");

    Pokemon pata;
    Pokemon nero;

    @Before
    public void setup(){
        System.setOut(new PrintStream(output));
        System.setErr(new PrintStream(errorOutput));

        pata = new Pokemon("Pata", 100, 10);
        nero = new Pokemon("Nero", 24, 10);

        PokemonTrainer patrick = new PokemonTrainer("Patrick");

        //these may have to be modified later, once the MyObservable/MyObserver classes are written
        //but it will essentially work the same
        pata.addObserver(patrick);
        nero.addObserver(patrick);
    }

    /*
    Testable output
    PokemonTrainer Patrick is notified that Pokemon Nero attacked Pokemon Pata using Body Slam for 10 damage.
    PokemonTrainer Patrick is notified that Pokemon Pata attacked Pokemon Nero using Body Slam for 10 damage.
    PokemonTrainer Patrick is notified that Pokemon Pata attacked Pokemon Nero using Body Slam for 10 damage.
    PokemonTrainer Patrick is notified that Pokemon Pata attacked Pokemon Nero using Body Slam for 4 damage.Pokemon Nero is dead.

    from these commands:
    nero.attack(pata);
    pata.attack(nero);
    pata.attack(nero);
    pata.attack(nero);
    */

    @Test
    public void testPkmnOut(){
        nero.attack(pata);
        //System.out.println();//call the actual outputs from the class methods
        assertEquals("PokemonTrainer Patrick is notified that Pokemon Nero attacked Pokemon Pata using Body Slam for 10 damage." + lineSeparator, output.toString());//compare what they should say to what is in the buffer
    }

    @Test
    public void testPkmnErr(){
        
        try{
            while(true){
                pata.attack(nero);
                if(nero.getHealth() == 0){
                    throw new Exception();
                }
            }
        }
        catch (Exception e){
            System.err.println("Stop beating it... it fainted.");
        }
        
        assertEquals("Stop beating it... it fainted." + lineSeparator, errorOutput.toString());
    }

    @After
    public void resetStreams(){
        System.setOut(System.out);
        System.setErr(System.err);
    }

}