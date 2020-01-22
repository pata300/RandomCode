/**
@author P. Griffin
@since March 22, 2019
*/
import java.util.ArrayList;

public class StringCompare{

    /**
        Recursive function that takes two strings as parameters and compares them. 
        @param s1   First string that will be compared to the following

        @param s2   Second string that the first string is compared to

        @return 0 if the two strings are the same, 1 if the first string comes after the second string
                -1 if the first string comes before the second string
    */
    public static int compareTo(String s1, String s2){

        int index = 0;
        int subIndex = 1;

        //set the strings to lowercase before comparing
        char c1 = s1.charAt(index);
        char c2 = s2.charAt(index);

        if(s1.length() == 1 && s2.length() == 1){
            if(Character.toLowerCase(c1) == Character.toLowerCase(c2)){
                return 0;
            } else if(Character.toLowerCase(c1) > Character.toLowerCase(c2)){
                return 1;
            } else { return -1; }
        }else if(s1.length() == 1){
                    return -1;
        }else if(s2.length() == 1){
                    return 1;
        }else{
            if(Character.toLowerCase(c1) == Character.toLowerCase(c2)){
                //index++;
                //System.out.println(s1 + " " + s2);
                return compareTo(s1.substring(subIndex), s2.substring(subIndex));
            } else if(Character.toLowerCase(c1) > Character.toLowerCase(c2)){
                return 1; //comes after
            } else { return -1; } //comes before
        }

    }

    static String minimumString = "";
    static int index = 1;
    static boolean initLoop = true;
    static int compareInt;

    /**
        Recursive function that used compareTo() to find the minimum or
        alphabetically first word in an arraylist.
        @param stringArray an arrayList of strings that are used to compare
        amongst each other
        @return a string that represents the alphabetically first word in the list
    */
    public static String findMinimum(ArrayList<String> stringArray){

        try{
            stringArray.get(index);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("There is nothing to compare.");
        }
        
        if(initLoop){
            //index = 0;
            initLoop = false;
            minimumString = stringArray.get(0);
        }

        // System.out.println("Now comparing " + minimumString + " and " + stringArray.get(index));
        // System.out.println("index is:");
        // System.out.println(index + 1);
        // System.out.println("String size:");
        // System.out.println(stringArray.size());

        if(index + 1 == stringArray.size()){
           compareInt = compareTo(minimumString, stringArray.get(index));
           //System.out.println("Compare int returned: " + compareInt);
           if(compareInt == 0){
                return minimumString;
           } else if(compareInt > 0){
                return minimumString = stringArray.get(index);
           } else { return minimumString; }
        } else {
            compareInt = compareTo(minimumString, stringArray.get(index));
            //System.out.println("Compare int returned: " + compareInt);
            if(compareInt > 0){
                minimumString = stringArray.get(index);
            }
            index++;
            //System.out.println("The min string is: " + minimumString);
            return findMinimum(stringArray);
        }

    }

}