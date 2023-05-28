package com.carops.controllers;

import com.carops.CarOps;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreenController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onOwnerScreen_click() throws IOException {
        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(CarOps.class.getResource("owners-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), visualBounds.getWidth() * 0.7, visualBounds.getHeight() * 0.7);
        stage.setTitle("CarOps Information System - Owner Tools");
        stage.setScene(scene);
        stage.show();

    }
}