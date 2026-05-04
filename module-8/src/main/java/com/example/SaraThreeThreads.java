// Sara White - CSD-420 - Assignment 8.2

package com.example;

import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SaraThreeThreads extends Application {

    // create text area for thread output
    // private - only TextArea will be able to access/modify output
    private TextArea outputArea = new TextArea();

    @Override
    public void start(Stage stage) {

        // prevent user editing
        outputArea.setEditable(false);

        // create pane and add text area
        BorderPane pane = new BorderPane();
        pane.setCenter(outputArea);

        // create scene 
        Scene scene = new Scene(pane, 500, 500);

        // create runnable tasks
        Runnable letterTask = new LetterTask();
        Runnable numberTask = new NumberTask();
        Runnable symbolTask = new SymbolTask();

        // create threads
        Thread letterThread = new Thread(letterTask);
        Thread numberThread = new Thread(numberTask);
        Thread symbolThread = new Thread(symbolTask);

        // start threads
        letterThread.start();
        numberThread.start();
        symbolThread.start();

        // configure stage
        stage.setTitle("SaraThreeThreads");
        stage.setScene(scene);
        stage.show();
    }

    // task for generating random letters
    // Runnable lets class define a task that can be executed by a thread
    class LetterTask implements Runnable {
        @Override
        public void run() {
            Random random = new Random();
            // generate 10,000 random letters
            for (int i = 0; i < 10000; i++) {
                char randomLetter = (char) ('a' + random.nextInt(26));
                // update JavaFX GUI safely with Platform.runLater
                Platform.runLater(() -> outputArea.appendText(String.valueOf(randomLetter)));

                try {
                    Thread.sleep(1);
                }
                catch (InterruptedException ex) {
                }
            }
        }
    }

    // task for generating random numbers
    class NumberTask implements Runnable {

        @Override
        public void run() {

            Random random = new Random();

            // generate 10,000 random digits
            for (int i = 0; i < 10000; i++) {

                int randomDigit = random.nextInt(25);

                Platform.runLater(() -> outputArea.appendText(String.valueOf(randomDigit)));

                try {
                    Thread.sleep(1);
                }
                catch (InterruptedException ex) {
                }
            }
        }
    }

    // task for generating random symbols
    class SymbolTask implements Runnable {

        @Override
        public void run() {

            Random random = new Random();
            // possible special characters
            char[] symbols = {'!', '@', '#', '$', '%', '&', '*', '^'};
            // generate 10,000 random symbols
            for (int i = 0; i < 10000; i++) {
                char randomSymbol = symbols[random.nextInt(symbols.length)];

                // Platform.runLater prevents conflicts on the UI
                // and ensures updates happen in a safe order
                Platform.runLater(() -> outputArea.appendText(String.valueOf(randomSymbol)));
                try {
                    Thread.sleep(1);
                }
                catch (InterruptedException ex) {
                }
            }
        }
    }

    public static void main(String[] args) {

        launch(args);
    }
}


// References

// Coder Scratchpad. (2023, August 21). JavaFX TextArea: Multi-Line Text Input. https://coderscratchpad.com/javafx-textarea-multi-line-text-input/

// GeeksforGeeks. (n.d.). Java Runnable Interface. https://www.geeksforgeeks.org/java/runnable-interface-in-java/

// Liang, Y. D. (2024). Introduction to Java programming and data structures: Comprehensive version (13th ed.). Pearson.  

// Oracle. (n.d.). Class TextArea https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextArea.html

// Reddit. (n.d.). When should I be using Platform.runLater() in javafx? https://www.reddit.com/r/JavaFX/comments/11ery89/when_should_i_be_using_platformrunlater_in_javafx/


 