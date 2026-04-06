// Sara White - CSD-420 - Assignment 2.2

import java.io.*;
import java.util.Random;

public class RandomNumberWriter {
    public static void main(String[] args) {
        // create arrays to hold the random integers/doubles (5 each)
        int[] intArray = new int[5];
        double[] doubleArray = new double[5];

        Random random = new Random();

        // Generate random integers to assign to array
        for (int i = 0; i < intArray.length; i++) {

            intArray[i] = random.nextInt();
        }

        // Generate random doubles to assign to array
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = random.nextDouble();
        }

        // using try/catch to write output to the file - it will close the file when the try block ends
        try (PrintWriter output = new PrintWriter(new FileWriter("SaraDatafile.dat", true))) {
            
            output.println("\n-----------------\nRandom Integers\n-----------------\n"); // formatting output
            for (int num : intArray) {
                output.print(num + " \n");
            }

            output.println("\n-----------------\nRandom Doubles\n-----------------\n");
            for (double num : doubleArray) {
                output.print(num + "\n");
            }
            output.println();

            // display statement to user showing file was successfully written to
            System.out.println("\nYour file has been updated. Open the file to see the results.\n");

            // error message output if exception occurs
        } catch (IOException e) {
            System.out.println("\nAn error occurred. Your file was not updated\n");
            e.printStackTrace();
        }
    }
}

// References

// GeeksforGeeks. (n.d.). How to Add Random Number to an Array in Java?. https://www.geeksforgeeks.org/java/add-random-number-to-an-array-in-java/

// GeeksforGeeks. (n.d.). Java.io.OutputStream class in Java. https://www.geeksforgeeks.org/java/java-io-outputstream-class-java/

// Liang, Y. D. (2024). Introduction to Java programming and data structures: Comprehensive version (13th ed.). Pearson.