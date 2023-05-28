package com.carops.controllers;

import com.carops.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OwnersMainScreen  {

    @FXML
    protected void onStatViewButton_Click(){
        System.out.println("debug point!");
    }

    public void onEngAsgnm_click(MouseEvent mouseEvent) throws IOException {
        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("owners-screen-assignment.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), visualBounds.getWidth() * 0.7, visualBounds.getHeight() * 0.7);
        stage.setTitle("CarOps Information System - Owner Tools view assignments");
        stage.setScene(scene);
        stage.show();

    }


}
