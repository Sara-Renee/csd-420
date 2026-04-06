// Sara White - Assignment 1.3 - CSD-420

package com.sar;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.paint.CycleMethod;



public class CardsApp extends Application {

    private final ImageView card1 = new ImageView();
    private final ImageView card2 = new ImageView();
    private final ImageView card3 = new ImageView();
    private final ImageView card4 = new ImageView();

    @Override
    public void start(Stage stage) {
        HBox cardBox = new HBox(10, card1, card2, card3, card4);
        cardBox.setAlignment(Pos.CENTER);

        // card sizing
        card1.setFitWidth(100);
        card1.setPreserveRatio(true);

        card2.setFitWidth(100);
        card2.setPreserveRatio(true);

        card3.setFitWidth(100);
        card3.setPreserveRatio(true);

        card4.setFitWidth(100);
        card4.setPreserveRatio(true);

        Button refreshButton = new Button("Refresh");

        // Lambda expression
        refreshButton.setOnAction(e -> displayCards());

        VBox root = new VBox(20, cardBox, refreshButton);
        root.setAlignment(Pos.CENTER);

        // gradient for background
        LinearGradient gradient = new LinearGradient(
        0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
        new Stop(0, Color.LIMEGREEN),
        new Stop(1, Color.LIME)
);


root.setBackground(new Background(
        new BackgroundFill(gradient, null, null)
));

// styling for the refresh button
refreshButton.setStyle(
    "-fx-background-color: #ffffff;" +
    "-fx-background-radius: 10;" +
    "-fx-text-fill: black;" +
    "-fx-font-size: 14px;" +
    "-fx-border-radius: 10;" +
    "-fx-border-color: rgb(0, 0, 0);"
);
        

        displayCards();

        Scene scene = new Scene(root, 500, 250);
        stage.setTitle("Random Playing Cards");
        stage.setScene(scene);
        stage.show();
    }

    private void displayCards() {
    
        List<Integer> deck = new ArrayList<>();
        // use a loop to add the numbers 1 through 52 to the deck list
        for (int i = 1; i <= 52; i++) {
            deck.add(i);
        }

        Collections.shuffle(deck);
        // use the first 4 numbers in the shuffled deck list to load 4 random card images
        card1.setImage(loadCardImage(deck.get(0)));
        card2.setImage(loadCardImage(deck.get(1)));
        card3.setImage(loadCardImage(deck.get(2)));
        card4.setImage(loadCardImage(deck.get(3)));
    }

    // load a card image based on its card number
    private Image loadCardImage(int cardNumber) {
        String imagePath = "/cards/" + cardNumber + ".png";
        return new Image(getClass().getResourceAsStream(imagePath));
    }

    public static void main(String[] args) {
        launch();
    }
}

// References
// 
// Liang, Y. D. (2024). Introduction to Java programming and data structures: Comprehensive version (13th ed.). Pearson.
// Oracle. (n.d.). Class Color. https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html
// Oracle. (n.d.). JavaFX CSS References Guide. https://docs.oracle.com/javase/8/javafx/api/javafx/scene/doc-files/cssref.html

