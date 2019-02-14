// import java.util.Observer;
// import java.util.Observable;

public class MyObservable //implements MyObserver
{

    private static MyObserver[] obserArray1;
    //private static MyObservable[] tempObser;
    private static MyObserver[] obserArray2;

    private static int numOfObservables = 0;

    private boolean hasChanged;

    public MyObservable(){
        
    }

    public static void addObserver(MyObserver o){

        //o = newObserver();
        MyObserver newObserver = o; //= new MyObservable();
        numOfObservables++;
        
        if(numOfObservables > 1){
            obserArray2 = new MyObserver[numOfObservables];
            obserArray2[numOfObservables - 1] = newObserver;
            //tempObser = new MyObservable[obserArray2.length];
            for (int i = 0; i < obserArray1.length - 1; i++){
                obserArray2[i] = obserArray1[i];
            }
            obserArray1 = new MyObserver[obserArray2.length];
            for (int i = 0; i < obserArray2.length; i++){
                obserArray1[i] = obserArray2[i];
            }
        } else {
            obserArray1 = new MyObserver[1];
            obserArray1[0] = newObserver;
        }
    }

    protected void clearChanged(){
        hasChanged = false;
    }

    //keep track of how many MyObservers have registered
    public int countObservers(){
        return numOfObservables;
    }

    public boolean hasChanged(){
        return hasChanged;
    }

    // public void notifyObservers(){

    //     if(hasChanged){
    //         for(int i = 0; i < obserArray1.length; i++){
    //             obserArray1[i].update(this, arg);
    //         }
    //     }

    //     clearChange();
    // }

    public void notifyObservers(Object arg){

        if(hasChanged()){
            for(int i = 0; i < obserArray1.length; i++){
                //if(obserArray1[i].getName() == )
                //obserArray1[i].
                update(this, arg); //keeps pointed to this object instead of pkmn trainer
            }
        }

        clearChanged();
    }

    protected void setChanged(){
        hasChanged = true;
    }

    // @Override
    // /**
    //     {@inheritdoc}
    // */
    // public void update(MyObservable obs, Object o) {
    //     String whatHappened = "";
    //     whatHappened += obserArray1[0] + " is notified that " + o;
    //     System.out.println(whatHappened);
    // }

}