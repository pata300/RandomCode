import java.util.ArrayList;
/**
 * @author Patrick Griffin
 * @since 02/14/2019
 * @version 1.1
 * 
 */
public class MyObservable //implements MyObserver
{

    //private static MyObserver[] obserArray = new MyObserver[10];
    //private static MyObservable[] tempObser;
    //private static MyObserver[] obserArray2;
    private ArrayList<MyObserver> obserArray = new ArrayList<MyObserver>();

    private static int numOfObservers = 0; //running tally of all the observers added; share among MyObservable class
    private int numOfObserversInClass;
    private boolean hasChanged; //keeps track of if MyObservable has changed
    
    /**
     *  Constructs a MyObservable with no parameters
     */
    public MyObservable(){
        numOfObserversInClass = 0;
    }

    /**
     * add a MyObserver class to an array of MyObserver[] 
     * static variable numOfObservers is increamented each time a new observer is added to the array
     * @param o the MyObserver that is being added to MyObservable
     */
    public void addObserver(MyObserver o){

        //o = newObserver();
        MyObserver newObserver = o; //= new MyObservable();
        numOfObservers++;
        numOfObserversInClass++;

        //obserArray[numOfObserversInClass - 1] = o;
        obserArray.add(o);

        // if(numOfObservables > 1){
        //     obserArray2 = new MyObserver[numOfObservables];
        //     obserArray2[numOfObservables - 1] = newObserver;
        //     //tempObser = new MyObservable[obserArray2.length];
        //     for (int i = 0; i < obserArray1.length - 1; i++){
        //         obserArray2[i] = obserArray1[i];
        //     }
        //     obserArray1 = new MyObserver[obserArray2.length];
        //     for (int i = 0; i < obserArray2.length; i++){
        //         obserArray1[i] = obserArray2[i];
        //     }
        // } else {
        //     obserArray1 = new MyObserver[1];
        //     obserArray1[0] = newObserver;
        // }
    }

    /**
     * resets the state MyObservable once it has notified the observers
     */
    protected void clearChanged(){
        hasChanged = false;
    }

    /**
     * keep track of how many MyObservers have registered
     * @return Returns an int of the number of MyObserver objects connected to MyObservable
     */
    public int countObservers(){
        return numOfObservers;
    }

    public int countObserversInClass(){
        return numOfObserversInClass;
    }

    /**
     * returns weither MyObservable has changed or not
     * @return Returns a boolean of what the current status MyObservable is in; which is either has changed or has not changed
     */
    public boolean hasChanged(){
        return hasChanged;
    }

    /**
     * checks if MyObservable has changed
     * if it has, the method loops through the array of MyObservers and notifies them to update
     * MyObservable is then reset/cleared of change
     * @param arg This is a message package that you want to pass to the update() of MyObserver
     */
    public void notifyObservers(Object arg){

        if(hasChanged()){
            for(int i = 0; i < obserArray.size(); i++){
                //if(obserArray1[i].getName() == )
                if(obserArray.get(i) != null)
                obserArray.get(i).update(this, arg); //keeps pointed to this object instead of pkmn trainer
            }
        }

        clearChanged();
    }

    /**
     * sets MyObservable's hasChanged to true
     */
    protected void setChanged(){
        hasChanged = true;
    }

    /**
     * Deletes a specific MyObserver from the MyObservable's list
     * @param o This is the MyObserver object that is being checked for deletion
     */
    public void deleteObserver(MyObserver o){
        //loops through the array list of observers
        for(int i = 0; i < obserArray.size(); i++){
            //if the passed observer matches the obsever in the array, it is deleted (or set to null)
            if(o.equals(obserArray.get(i))){
                //obserArray.get(i) = null;
                obserArray.remove(i);
                numOfObservers--;
                numOfObserversInClass--;
            }
        }
    }

    /**
     * Deletes all MyObserver objects that are populated within this MyObservable
     */
    public void deleteObservers(){
        //loops through the array list of observers
        for(int i = 0; i < obserArray.size(); i++){
            if(obserArray.get(i) != null){
                numOfObservers--;
                //set all MyObservers to null
                //obserArray[i] = null;
                numOfObserversInClass--;
            }
        }

        obserArray.clear();

    }

}