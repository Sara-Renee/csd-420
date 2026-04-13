// Sara White - Assignment 3.2 - CSD-420

import java.util.ArrayList;
import java.util.Random;

public class Mod3_2 {
	public static void main(String [] args){
		ArrayList<Integer> list1 = new ArrayList<>();
        Random randint = new Random();

        // populate list1 with 50 random values between 1 and 20
		for (int i = 0; i < 50; i++) {
            // '+1' to move range from 0-19 to 1-20
            list1.add(randint.nextInt(20) +1);
        }

        // display contents of list1
	    System.out.println("\nList #1: \n" + list1 + "\n");

        // create list for removeDuplicates method to hold amended values
        // a new list (a third list) will be created inside of the
        // removeDuplicates generic method
        ArrayList<Integer> list2 = removeDuplicates(list1);

        // display contents of list2
        System.out.println("\nList #2 with duplicates removed: \n" + list2 + "\n");
    }

    // generic method removeDuplicates
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        // third list created that only holds unique values
        ArrayList<E> list3  = new ArrayList<>();
        // for loop to traverse through elements in list
        for (E element: list) {
            // if list3 does not contain the element, add it to the list
            // this step will exclude duplicate integers
            if (!list3.contains(element)) {
                list3.add(element);
            }
        }
        return list3;
    }
       
}


// References

// GeeksforGeeks. (n.d.). How to Remove Duplicates from ArrayList in Java. https://www.geeksforgeeks.org/java/how-to-remove-duplicates-from-arraylist-in-java/

// GeeksforGeeks. (n.d.). Java.util.Random.nextInt() in Java. https://www.geeksforgeeks.org/java/java-util-random-nextint-java/

// Liang, Y. D. (2024). Introduction to Java programming and data structures: Comprehensive version (13th ed.). Pearson.

