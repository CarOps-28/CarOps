package com;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class VehicleCreationScreenController {
    public Button vehicleCreationBtn;
    private Stage stage;
    private Parent root;

    @FXML
    private Button goBackBtn;

    @FXML
    private TextField vehiclePlatenumber;
    @FXML
    private TextField vehicleBrand;
    @FXML
    private TextField vehicleModel;
    @FXML
    private TextField vehicleProdYear;
    @FXML
    private TextField vehicleType;
    @FXML
    private TextField vehicleTypeValue;

    private void sceneGenerator(String Screen_Name, MouseEvent event, String Screen_Title) throws IOException {
        root = FXMLLoader.load(getClass().getResource(Screen_Name));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.setHeight(700);
        stage.setWidth(900);
        stage.setTitle(Screen_Title);
        stage.show();
    }


    @FXML
    void mouseClicked(MouseEvent event) throws IOException {
        if (event.getSource() == goBackBtn){
            sceneGenerator("SecretaryScreen-view.fxml", event, "Secretary Screen");
        }else if (event.getSource() == vehicleCreationBtn){
            StartScreenController.secretary.createVehicle(vehiclePlatenumber.getText(),vehicleBrand.getText(),vehicleModel.getText(), Integer.parseInt(vehicleProdYear.getText()),vehicleType.getText(), Float.parseFloat(vehicleTypeValue.getText()));
            vehiclePlatenumber.setText("Successful creation");
            vehicleBrand.setText("");
            vehicleModel.setText("");
            vehicleProdYear.setText("");
            vehicleType.setText("");
            vehicleTypeValue.setText("");
        }
    }

    @FXML
    void initialize() {
        assert goBackBtn != null : "fx:id=\"goBackBtn\" was not injected: check your FXML file 'VehicleCreationScreen-view.fxml'.";
        assert vehiclePlatenumber != null : "fx:id=\"vehiclePlatenumber\" was not injected: check your FXML file 'VehicleCreationScreen-view.fxml'.";
        assert vehicleBrand != null : "fx:id=\"vehicleBrand\" was not injected: check your FXML file 'VehicleCreationScreen-view.fxml'.";
        assert vehicleModel != null : "fx:id=\"vehicleModel\" was not injected: check your FXML file 'VehicleCreationScreen-view.fxml'.";
        assert vehicleProdYear != null : "fx:id=\"vehicleProdYear\" was not injected: check your FXML file 'VehicleCreationScreen-view.fxml'.";
        assert vehicleType != null : "fx:id=\"vehicleType\" was not injected: check your FXML file 'VehicleCreationScreen-view.fxml'.";
        assert vehicleTypeValue != null : "fx:id=\"vehicleTypeValue\" was not injected: check your FXML file 'VehicleCreationScreen-view.fxml'.";
        assert vehicleCreationBtn != null : "fx:id=\"vehicleCreationBtn\" was not injected: check your FXML file 'VehicleCreationScreen-view.fxml'.";

        vehicleTypeValue.setText("0");
    }


}