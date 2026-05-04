// Sara White - CSD-420 - Assignment 7.2

package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Mod7_2 extends Application {

  @Override
  public void start(Stage primaryStage) {

    // create horizontal layout with 5px of spacing
    HBox hBox = new HBox(5);

    //create scene with demensions 500px X 500px
    Scene scene = new Scene(hBox, 500, 500);   
   
    // load externbal CSS stylesheet for circle and pane styling
    scene.getStylesheets().add(
      getClass().getResource("Mod7_2_stylesheet.css").toExternalForm());

    // create left pane to hold top and bottom left circles
    Pane leftPane = new Pane();
    // create circle objects
    // parameters (x-coordinate, y-coordinate, radius)
    Circle topLeftCircle = new Circle(80, 120, 60);
    Circle bottomLeftCircle = new Circle(80, 380, 60);

    
    // define content for first pane
    leftPane.getChildren().addAll(topLeftCircle, bottomLeftCircle);
    // style left pane border
    leftPane.getStyleClass().add("paneBorder");
    // style circles
    topLeftCircle.setId("blueCircle");
    bottomLeftCircle.setId("greenCircle");
    
 
    Pane middlePane = new Pane();
    Circle centerCircle = new Circle(80, 250, 60);

    // define content for middle pane
    middlePane.getChildren().add(centerCircle);

    // style middle pane border
    middlePane.getStyleClass().add("paneBorder");

    // style center circle
    centerCircle.getStyleClass().add("whiteCircle");
   

    Pane rightPane = new Pane();
    Circle topRightCircle = new Circle(80, 120, 60);
    Circle bottomRightCircle = new Circle(80, 380, 60);
   
    // define content for right pane
    rightPane.getChildren().addAll(topRightCircle, bottomRightCircle);
    // style right pane border
    rightPane.getStyleClass().add("paneBorder");
    // style circles
    topRightCircle.setId("pinkCircle");
    bottomRightCircle.setId("yellowCircle");


    hBox.getChildren().addAll(leftPane, middlePane, rightPane); 
    
    primaryStage.setTitle("Mod7_2");
  
    primaryStage.setScene(scene);


    primaryStage.show();
  }

 
  public static void main(String[] args) {

    launch(args);
  }
}
