// Sara White - CSD-420 - Assignment 5.2

import java.io.*;
import java.util.TreeSet;
import java.util.Scanner;

public class Mod5_2 {
    public static void main(String[] args) {

        
        // create Set object to hold input from .txt file
        TreeSet<String> setDisplay = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        // create Scanner object to read collection_of_words.txt
        try (Scanner input = new Scanner(new File("collection_of_words.txt"))) {

            // read and add each word to set
            while (input.hasNext()) {
                String word = input.next();
                // my text example has a lot of punctuation
                // so this line will ignore punctuation for ordering the words
                // instead of defaulting to natural order
                word = word.replaceAll("[^a-zA-Z]", "");

                if (!word.isEmpty()) {
                    setDisplay.add(word);
                }
            }

        } 
            catch (IOException e) {
            // display statement if exception occurs
            System.out.println("An error occurred and the file could not be read.");
            e.printStackTrace();
            }

        // display contents of each set
        // formatting with printf and loop to display words
        // in a numbered list
        System.out.println("\nWords from File in Ascending Order:");
        // initialize the count
        int count = 1;
        for (String word : setDisplay) {
            System.out.printf("%2d. %s%n", count++, word);
        }

        System.out.println("\nWords from File in Descending Order:");
        count = 1;
        for (String word : setDisplay.descendingSet()) {
            System.out.printf("%2d. %s%n", count++, word);
        }
    }
}

// References

// GeeksforGeeks. Remove all non-alphabetical characters of a String in Java. https://www.geeksforgeeks.org/java/remove-all-non-alphabetical-characters-of-a-string-in-java/

// Liang, Y. D. (2024). Introduction to Java programming and data structures: Comprehensive version (13th ed.). Pearson.