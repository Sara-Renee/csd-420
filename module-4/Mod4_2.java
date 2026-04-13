// Sara White - Assignment 4.2 - CSD-420

import java.util.LinkedList;
import java.util.Random;
import java.util.Iterator;

public class Mod4_2 {
    public static void main(String[] args) {

        // test with 50,000 elements
        testTraversal(50000);

        // test with 500,000 elements
        // calling the method twice to avoid duplicate code
        testTraversal(500000);  
    }

    public static void testTraversal(int size) {

        // create an empty LinkedList to store integers
        LinkedList<Integer> list = new LinkedList<>();

        // create a Random object to generate integers
        Random randint = new Random();

        // populate list1 with random integers
    	// i'm setting the range to 1-10
        for (int i = 0; i < size; i++) {
            list.add(randint.nextInt(10) + 1);
        }

        System.out.println("\n" + size + " integers:");

        // timing the iterator
        // I used nanoTime because I read it was recommended over currentTimeMillis
        // and then I convert the results into milliseconds later
        long start_iterator = System.nanoTime();

        // creating an iterator for the list of integers
        Iterator<Integer> iterator = list.iterator();
        // while loop to continue while integers remain in list
        while (iterator.hasNext()) {
            iterator.next();
        }

        // recording the time taken for the operation
        long end_iterator = System.nanoTime();
        // calculating how long it took to run
        long total_iterator = end_iterator - start_iterator;

        System.out.println("\nThe traversal time using iterator was " + (total_iterator / 1_000_000) + "ms.");

      
        // timing get(index)
        
        long start_getindex = System.nanoTime();

        // accessing each integer using get(index)
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }

        long end_getindex = System.nanoTime();
        long total_getindex = end_getindex - start_getindex;

        System.out.println("\nThe traversal time using get(index) was " + (total_getindex / 1_000_000) + "ms.\n");
    }
}

// Here are my results:
// 50000 integers:

// The traversal time using iterator was 2ms.
// The traversal time using get(index) was 745 ms.

// 500000 integers:

// The traversal time using iterator was 5ms.
// The traversal time using get(index) was 107284 ms.

// Using get(index) for 500,000 integers was by far the longest operation.
// Get(index) has to start from the beginning of the list each time, so it was 
// much less efficient.

// References

// GeeksforGeeks. (n.d.). How to measure time taken by a function in java?. https://www.geeksforgeeks.org/java/measure-time-taken-function-java/

// Liang, Y. D. (2024). Introduction to Java programming and data structures: Comprehensive version (13th ed.). Pearson.

// Tutorials Point. (n.d.). Java LinkedList get() Method. https://www.tutorialspoint.com/java/util/linkedlist_get.htm