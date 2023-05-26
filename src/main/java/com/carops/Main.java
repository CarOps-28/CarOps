package com.carops;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

public class Main extends Application {
//    Create GUI
    @Override
    public void start(Stage stage) throws IOException {

        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("start-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), visualBounds.getWidth() * 0.7, visualBounds.getHeight() * 0.7);
        stage.setTitle("CarOps Information System");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        // Create objects here
        // create secretary
        LinkedList<Secretary> secretaries = new LinkedList<Secretary>();
        secretaries.add(new Secretary("@sec1", "Johana", "Ajax"));
        secretaries.add(new Secretary("@sec2", "John", "super apt update"));
        // steps tha a secretary may follow to create a vehicle
        secretaries.get(0).createVehicle("2YFZ101", "TOYOTA", "90Turbo", 1989, "Vehicle");
        secretaries.get(1).createVehicle("2YFZ101", "Lincoln", "Wyoming", 2008, "Vehicle");
        secretaries.get(0).createVehicle("Wyoming", "Land", "LandRover Range Rover HSE", 2014, "Vehicle");
        secretaries.get(1).createTruck("SQR216", "CHEVROLET", "CHEVROLETCOLORADO", 2005, "Vehicle", 159);



//        Run GUI
        launch();

//        Console
        System.out.println("CarOps Information System closing . . . ");
    }
}