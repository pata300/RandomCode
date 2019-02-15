// import java.util.Observer;
// import java.util.Observable;

public class MyObservable //implements MyObserver
{

    //private static MyObserver[] obserArray = new MyObserver[10];
    //private static MyObservable[] tempObser;
    //private static MyObserver[] obserArray2;
    private MyObserver[] obserArray = new MyObserver[10];

    private static int numOfObservers = 0; //running tally of all the observers added; share among MyObservable class

    private boolean hasChanged; //keeps track of if MyObservable has changed

    public MyObservable(){
        
    }

    //add a MyObserver class to an array of MyObserver[]
    //static variable numOfObservers is increamented each time a new observer is added to the array
    public void addObserver(MyObserver o){

        //o = newObserver();
        MyObserver newObserver = o; //= new MyObservable();
        numOfObservers++;

        obserArray[numOfObservables - 1] = o;
        
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

    //resets the state MyObservable once it has notified the observers
    protected void clearChanged(){
        hasChanged = false;
    }

    //keep track of how many MyObservers have registered
    public int countObservers(){
        return numOfObservers;
    }

    //returns weither MyObservable has changed or not
    public boolean hasChanged(){
        return hasChanged;
    }

    //checks if MyObservable has changed
    //if it has, the method loops through the array of MyObservers and notifies them to update
    //MyObservable is then reset/cleared of change
    public void notifyObservers(Object arg){

        if(hasChanged()){
            for(int i = 0; i < obserArray.length; i++){
                //if(obserArray1[i].getName() == )
                if(obserArray[i] != null)
                obserArray[i].update(this, arg); //keeps pointed to this object instead of pkmn trainer
            }
        }

        clearChanged();
    }

    //sets MyObservable's hasChanged to true
    protected void setChanged(){
        hasChanged = true;
    }

}