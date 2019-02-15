import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;
import org.junit.*;

//import jdk.internal.jline.internal.TestAccessible;

public class PokemonTester {

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private ByteArrayOutputStream errorOutput = new ByteArrayOutputStream();

    private String lineSeparator = System.getProperty("line.separator");

    //declare two pokemon to test
    Pokemon pata;
    Pokemon nero;

    //declare a pokemontrainer to observe the pokemon
    PokemonTrainer patrick;

    //setup class is ran before each test
    //assigned variables to the output and error buffer
    //construct two pokemon and a trainer; we then add the trianer to the Pokemon/MyObservable pata
    @Before
    public void setup(){
        //assigning to the buffer?
        System.setOut(new PrintStream(output));
        System.setErr(new PrintStream(errorOutput));

        //constructs two Pokemon objects to battle each other
        pata = new Pokemon("Pata", 100, 30);
        nero = new Pokemon("Nero", 24, 10);

        patrick = new PokemonTrainer("Patrick"); //constructs a pokemon trainer
        pata.addObserver(patrick); //adds the observer 'patrick' to the pokemon pata
    }

    //the first test
    //test for equality of pokemon pata's health before (100) and after(90) it has been attacked
    //test for equality of output when pokemon attack against the output buffer
    //test for equality of pokemon attackPower against 10
    //test for equality of pokemon pata's name
    //test for equality of pokemon trainer patrick's name
    //test for false if nero is dead
    //murder nero
    //test for true if nero is dead

    @Test
    public void testPkmnOut(){
        assertEquals(100, pata.getHealth());
        nero.attack(pata);
        assertEquals("PokemonTrainer Patrick is notified that Pokemon Nero attacked Pokemon Pata using Body Slam for 10 damage." + lineSeparator, output.toString());//compare what they should say to what is in the buffer
        assertEquals(90, pata.getHealth());
        assertEquals(10, nero.getAttackPower());
        assertEquals("Pata", pata.getName());
        assertEquals("Patrick", patrick.getName());
        assertFalse(nero.isDead());
        pata.attack(nero);
        assertTrue(nero.isDead());
    }

    //the second test
    //checks for an error that is thrown when you attack a fainted pokemon
    //if a pokemon treis to attack a pokemon with 0 health
    //the message "Stop beating it... it fainted."
    //is thrown to the error buffer
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

    //after each test the buffers are cleared
    @After
    public void resetStreams(){
        System.setOut(System.out);
        System.setErr(System.err);
    }

}