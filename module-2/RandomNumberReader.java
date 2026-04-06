// Sara White - CSD-420 - Assignment 2.2

import java.io.*;
import java.util.Scanner;

public class RandomNumberReader {
    public static void main(String[] args) {
        // try block to read, open and close file and display file contents
        // create Scanner object to read SaraDatafile.dat
        try (Scanner input = new Scanner(new File("SaraDatafile.dat"))) {
           // read and display each line in file
            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }

            // display statement if exception occurs
        } catch (IOException e) {
            System.out.println("An error occurred and the file could not be read.");
            e.printStackTrace();
        }
    }
}

// References

// GeeksforGeeks. (n.d.). How to Add Random Number to an Array in Java?. https://www.geeksforgeeks.org/java/add-random-number-to-an-array-in-java/

// GeeksforGeeks. (n.d.). Java.io.OutputStream class in Java. https://www.geeksforgeeks.org/java/java-io-outputstream-class-java/

// Liang, Y. D. (2024). Introduction to Java programming and data structures: Comprehensive version (13th ed.). Pearson.