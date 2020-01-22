import java.util.List;
import java.lang.Comparable;
public class Sorters2120 {


    public static <T extends Comparable<T> > void bubbleSort(List<T> theList) {
        int lastToConsider = theList.size();
        while (lastToConsider > 1) {
            for (int j=0; j<lastToConsider-1; j++) {
                if (theList.get(j).compareTo(theList.get(j+1))  >  0 ) {
                    swap(theList,j,j+1);
                }
            }
            lastToConsider--;
        }
    }

    private static <T extends Comparable<T> > void swap(List<T> theList, int i1, int i2) {

        T temp = theList.get(i1);
        theList.set(i1,theList.get(i2));
        theList.set(i2,temp);
    }

    public static <T extends Comparable<T> > void selectionSort(List<T> theList) {

        int smallest;

        for(int i = 0; i < theList.size() - 1; i++){
            smallest = i;

            for(int j = i + 1; j < theList.size(); j++){
                if(theList.get(smallest).compareTo(theList.get(j)) > 0){
                    smallest = j;
                }
            }

            swap(theList, i, smallest);
        }

    }

    public static <T extends Comparable<T> > void mergeSort(List<T> theList) {
        recursiveMergeSortHelper(theList,0,theList.size());
    }

    //static int recursiveLvl = 1;

    private static <T extends Comparable<T> > void recursiveMergeSortHelper(List<T> theList, int first, int last) {

        // stubbed
        if(first < last){

            int mid = first + (last - first) / 2;

            //System.out.println("First: " + first + " Last: " + last);
            recursiveMergeSortHelper(theList, first, mid);
            //System.out.println("First: " + first + " Last: " + last);
            recursiveMergeSortHelper(theList, first + 1, last);

            //System.out.println("Merging.");
            //System.out.println("First: " + first + " Last: " + last);
            //merge everything
            for(int i = first; i < last - 1; i++){
                if(theList.get(i).compareTo(theList.get(i + 1)) > 0){
                        swap(theList, i, i + 1);
                }
            }
            
            //System.out.println("Finish with recursion level " + recursiveLvl);
            //recursiveLvl++;
        } 

    }

    public static <T extends Comparable<T> > int indexOf(T searchItem, List<T> theList) {

        return recursiveBinarySearcher(searchItem, theList, 0, theList.size()-1);

    }

    private static <T extends Comparable<T> > int recursiveBinarySearcher(T searchItem, List<T> theList, int first, int last) {

        // stubbed
        int mid = (first + last) / 2;
        int compareVal = theList.get(mid).compareTo(searchItem);
        //System.out.println(compareVal);
        if(first > last){
            //System.out.println("first is greater than last");
            return -1;
        }

        if(searchItem.compareTo(theList.get(mid)) == 0){
            return mid;
        
        } else if(compareVal < 0) {
            first = mid +1;
            //System.out.println("item is greater than mid");
            return recursiveBinarySearcher(searchItem, theList, first, last);

        } else {
            last = mid -1;
            //System.out.println("item is less than mid");
            return   recursiveBinarySearcher(searchItem, theList, first, last);
        }

        // System.out.println("No matches");
        // return -1;

    }
}
